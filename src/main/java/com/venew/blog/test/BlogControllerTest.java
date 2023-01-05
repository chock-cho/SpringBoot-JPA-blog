package com.venew.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//스프링이 com.venew.blog 패키지 이하를 스캔하여,
//특정 어노테이션이 붙어있는 클래스파일들을 new해서(IoC) 스프링 컨테이너에 관리해준다.

//http://localhost:9090/test/hello
@RequestMapping("/test/hello")
public class BlogControllerTest {
	public String hello() {
		return "<h1>hello spring boot</h1>";
	}
	
}
