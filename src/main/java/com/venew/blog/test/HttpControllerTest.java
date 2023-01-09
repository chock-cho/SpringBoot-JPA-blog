package com.venew.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// 사용자가 요청하면 --> 응답(HTML파일)
// @Controller

//사용자가 요청하면 --> 응답(Data)
@RestController
public class HttpControllerTest {
	
	//http://localhost:8082/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "GET 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8082/http/post (insert)
	@PostMapping("/http/post") //text/plain, application/json
	public String postTest(@RequestBody Member m) { //MessageConverter(스프링부트)
		return "POST 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8082/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "PUT 요청"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8082/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "DELETE 요청"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+","+m.getEmail();
	}
}
