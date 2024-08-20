package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    // 문자셋 필터
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

        // 경로별 접근 권한 설정
        http.authorizeRequests()
                // 모든 사용자에게 접근 허용
                .antMatchers("/security/all").permitAll()
                // ADMIN 권한이 있는 사용자만 접근 가능
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                // MEMBER 권한이 있는 사용자만 접근 가능
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

        http.formLogin() // form 기반 로그인 활성화, 나머지는 모두 디폴트
                .loginPage("/security/login") // 로그인 페이지 GET 요청시
                .loginProcessingUrl("/security/login") // 로그인 페이지의 form에서 제출 시(action)
                .defaultSuccessUrl("/"); // 로그인 성공시 리다이렉트 페이지

        http.logout() // 로그아웃 설정 시작
                .logoutUrl("/security/logout") // POST: 로그아웃 호출 url
                .invalidateHttpSession(true) // 세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout"); // GET: 로그아웃 이후 이동할 페이지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        log.info("configure .........................................");
//        메모리 내에 인증 설정하는 방식
//        auth.inMemoryAuthentication()
//                .withUser("admin") // 사용자 이름 설정
////                .password("{noop}1234") // 사용자 비밀번호 설정(noop(no operation): 암호화 미적용)
//                .password("$2a$10$VJK.3K/W3PhSu53.FVm7WOEzFZPlGTw5.iiCZXgKTHPkhK419Jdz2")
//                .roles("ADMIN","MEMBER"); // ROLE_ADMIN ~ ADMIN + MEMBER 역할
//        auth.inMemoryAuthentication()
//                .withUser("member")
////                .password("{noop}1234")
//                .password("$2a$10$VJK.3K/W3PhSu53.FVm7WOEzFZPlGTw5.iiCZXgKTHPkhK419Jdz2")
//                .roles("MEMBER"); // ROLE_MEMBER ~ MEMBER 역할

        // in memory user 정보 삭제 → UserDetailsService와 같이 사용 불가
        auth
                .userDetailsService(userDetailsService) // 사용자 정보 로드
                .passwordEncoder(passwordEncoder()); // 비밀번호 암호화

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
