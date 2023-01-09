package com.venew.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TempControllerTest {
	
	//http://localhost:8082/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		
		//파일리턴 기본경로 : src/main/resources/static(정적파일)
		//리턴 명: /home.html
		//풀경로: src/main/resources/static/home.html
		return "/home.html";
	}
	
	//jsp는 컴파일이 필요한 동적 파일
	//파일리턴 경로: src/main/webapp/WEB-INF/views/test.jsp
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		//풀네임: /WEB-INF/views/test.jsp
		
		return "test";
	}

}
