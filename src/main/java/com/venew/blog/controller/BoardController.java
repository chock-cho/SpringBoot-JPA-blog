package com.venew.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.venew.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {

	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { //controller에서 세션을 어떻게 찾지?
		// /WEB-INF/views/index.jsp
		return "index"; 
	}
}
