package com.venew.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
	// 비밀번호 해시화
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable() //csrf 토큰 비활성화
		  .authorizeHttpRequests()
		    .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
			.anyRequest().authenticated()
		  .and()
		    .formLogin()
		    .loginPage("/auth/loginForm")
		    .loginProcessingUrl("/auth/loginProc")
		    //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채 대신 로그인을 해준다.
		    .defaultSuccessUrl("/")
		    ; 
		
		
		return http.build();
	}
}
