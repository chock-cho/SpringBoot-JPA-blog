package com.venew.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venew.blog.dto.ResponseDto;
import com.venew.blog.model.RoleType;
import com.venew.blog.model.User;
import com.venew.blog.serivce.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;

	// save에서 회원가입 로직이 실행되는 부분
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		//실제로 DB에 insert를 하고, 아래에서 return이 되면 된다.
		
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	/*
	 * @PostMapping("/auth/loginProc") 
	 * public ResponseDto<Integer>
	 * login(@RequestBody User user, HttpSession session) { 
	 * User principal =
	 * userService.로그인(user); //principal : 접근 주체
	 * 
	 * if(principal != null) { session.setAttribute("principal", principal); }
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); }
	 */
}

