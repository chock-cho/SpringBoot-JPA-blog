package com.venew.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Security 3종 세트
@Configuration //빈등록(IoC관리) : 스프링 컨테이너에서 객체를 관리할 수 있게 함
@EnableWebSecurity //security 필터 등록을 하겠다(설정하겠다는 뜻)
@EnableGlobalMethodSecurity(prePostEnabled = true)
// 특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다는 뜻

public class SecurityConfig {
	
	@Bean // IoC가 되어요!
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable() //csrf 토큰 비활성화
		  .authorizeHttpRequests()
		    .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		  .and()
		    .formLogin()
		    .loginPage("/auth/loginForm");
		
		return http.build();
	}
}
