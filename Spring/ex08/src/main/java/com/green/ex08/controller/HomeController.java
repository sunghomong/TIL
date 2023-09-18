package com.green.ex08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


// 컨트롤이라고 스프링에 인식을 시켜주는
@Controller
public class HomeController {
	
	@RequestMapping("/hello") // /hello라는 경로에 도착하면 해당 메서드 자동 호출
	public String hello(Model model,@RequestParam("name") String name) { // RequestParam("name") name 값이 입력받았을때만 출력,값이 없을시 400 에러
		
		model.addAttribute("greeting",name + "님 안녕하세요.");
		
		return "hello";		// prefix(/WEB-INF/views/) + hello + sufiix(hello.jsp)
	}
	
}
