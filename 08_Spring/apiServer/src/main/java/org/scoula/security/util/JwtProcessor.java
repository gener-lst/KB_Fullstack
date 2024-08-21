package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 5; // 토큰 유효기간을 5분으로 설정
    private String secretKey = "충분히 긴 임의의(랜덤한) 비밀키 문자열 배정"; // 비밀 키 설정 - 개발 시에는 재기동하는 경우가 많아 임의의 문자열 작성
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    // private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); -- 매번 변경되므로 운영시에만 사용

    // JWT 생성
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject) // 주로 사용자 식별용
                .setIssuedAt(new Date()) // JWT 발급 시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND)) // JWT 만료 시간
                .signWith(key) // JWT 서명을 위한 키 설정
                .compact(); // JWT 문자열 생성 및 반환
    }

    // JWT Subject(username) 추출 - 해석 불가인 경우 예외 발생
    // 예외 ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException -> runtimeException
    // ExpiredJwtException에 대해서는 특히 예외처리를 해야함 --> 위의 에러 발생시, 401 에러 출력해야 함
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // 서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token) // 토큰 파싱, jws는 서명이 있는 jwt로 파싱
                .getBody()
                .getSubject(); // subject(사용자 이름) 반환
    }

    // JWT 검증(유효 기간 검증) - 해석 불가인 경우 예외 발생(예외 발생 안 할경우 true 반환)
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key) // 서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token); // 토큰 파싱 및 서명 검증
        return true; // 유효한 토큰일 경우 true 반환
    }
}