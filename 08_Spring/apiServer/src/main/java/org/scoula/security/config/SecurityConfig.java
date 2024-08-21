package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager 빈 등록
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // cross origin 접근 허용 -> 다양한 도메인에서 서버에 요청을 보낼 수 있다
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // cors 설정을 적용할 URL 소스 생성
        CorsConfiguration config = new CorsConfiguration(); // cors 설정을 위한 객체 생성
        config.setAllowCredentials(true); // 자격 증명(쿠키, 인증 헤더 등)을 포함한 요청을 허용하도록 설정
        config.addAllowedOriginPattern("*"); // 모든 도메인에서 오는 요청 허용(*은 모두라는 의미)
        config.addAllowedHeader("*"); // 모든 헤더 허용
        config.addAllowedMethod("*"); // 모든 HTTP 메서드 허용(GET, POST, PUT, DELETE)
        source.registerCorsConfiguration("/**", config); // 설정된 CORS 구성을 모든 경로("/**")에 적용(하위 경로 포함)
        return new CorsFilter(source); // 설정된 소스 기반으로 새로운 corsFilter 반환
    }

    // 접근 제한 무시 경로 설정 – resource
    // 특정 경로에 대한 보안 필터를 적용하지 않도록 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
    }

    // 문자셋 필터
    // 문자셋 필터를 보안 필터와 별개로 둘 경우 보안 필터가 작동하며 문자셋 필터가 작동을 안 하고 문자열이 깨지게 됨
    // 이를 방지하기 위해 보안 필터(정확히 CSRF 필터 앞에) 문자셋 필터를 배치 -> configure에 addFilterBefore로 설정
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // addFilterBefore 메서드를 사용하여 CharacterEncodingFilter를 csrfFilter 이전에 적용
        // 이 설정은 모든 요청에 대해 UTF-8 인코딩 적용 후에 CSRF 보호가 되도록 함
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        http.httpBasic().disable() // 기본 HTTP 인증 비활성화
                .csrf().disable() // CSRF 비활성화
                .formLogin().disable() // formLogin 비활성화
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 생성 모드 설정(STATELESS : 세션 사용 안 함)
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth
                .userDetailsService(userDetailsService) // 사용자 정보 로드 -> 사용자 정보의 위치(userDetailService)
                                                        // 보통 템플릿처럼 사용될 때 이 위치만 customizing하면됨
                .passwordEncoder(passwordEncoder()); // 비밀번호 암호화
    }
}
