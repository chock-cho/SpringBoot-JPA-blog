package com.venew.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.venew.blog.model.User;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고, 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 저장소(PrincipalDetail)에 저장을 해준다.
public class PrincipalDetail implements UserDetails {
	private User user; //컴포지션
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴한다. 
	// 계정만료 true: 만료안됨 / false : 만료
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있지 않았는지 리턴한다.
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는지 리턴한다.
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능)인지 리턴한다.
	@Override
	public boolean isEnabled() {
		return true;
	} 
	
	// 계정이 갖고 있는 권한 목록을 리턴한다
	// 권한이 많이 있으면 for문을 돌려야 하는데 우리는 한 개만 있으면 된다.
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		/*
		 * collectors.add(new GrantedAuthority() {
		 * 
		 * // 자바는 오브젝트를 담을 순 있지만, 메서드를 넘길 순 없다.
		 * 
		 * @Override public String getAuthority() { return "ROLE_" + user.getRole();
		 * //ROLE_USER 리턴 //prefix를 꼭 설정해줘야 함 } });
		 */
		
		// 람다식 표현 가능
		collectors.add(() -> {
			return "ROLE_"+user.getRole(); //ROLE_USER, ROLE_ADMIN
			});
		return collectors;
	}
}
