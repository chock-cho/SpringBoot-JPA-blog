package com.venew.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.venew.blog.serivce.BoardService;

@Controller
//RestController가 아닌 Controller = 
// viewResolver 작동
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
		//controller에서 세션을 어떻게 찾지?
		//@AuthenticationPrincipal PrincipalDetail principal
	
	@GetMapping({"","/"})
	public String index(Model model) { 
		// /WEB-INF/views/index.jsp
		model.addAttribute("boards", boardService.글목록());
		return "index"; //viewResolver 작동(prefix와 suffix 붙여줌)
	}	
	
	//USER 권한 필요
	@GetMapping("/board/saveForm")
		public String saveForm() {
			return "board/saveForm";
		}
}
