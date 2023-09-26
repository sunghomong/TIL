package com.green.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/main")
	public String main() {
		return "스프링 부트에 오신것을 환영합니다.";
	}
}
