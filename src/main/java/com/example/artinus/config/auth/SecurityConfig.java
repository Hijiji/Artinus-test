package com.example.artinus.config.auth;


import com.example.artinus.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //스프링 시큐리티 설정을 활성화시킨다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//
                .and()
                .authorizeRequests()//URL별 권한 관리를 설정하는 옵션의 시작점,
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()//지정된 URL들은 전체열람가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//사용자권한가진사람만 접근가능
                .anyRequest().authenticated()//나머지 URL은 로그인한 사용자만 접근가능
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()//로그인 성공이후 사용저정보 가져올 떄 설정담당
                .userService(customOAuth2UserService);
    }
}