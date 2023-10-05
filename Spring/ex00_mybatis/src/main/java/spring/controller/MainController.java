package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = {"/main","/","/index"}) // 역할 :  /main 경로로 왔을 때 main.jsp로 연결
	public String main() {
		//기능 X
		return "main";  // 응답 경로  : /WEB-INF/views/main.jsp
	}
	
//	@RequestMapping("/","/main") // 역할 :  / 경로로 왔을 때 main.jsp로 연결
//	public String main2() {
//		//기능 X
//		return "main";  // 응답 경로  : /WEB-INF/views/main.jsp
//	}
	
}
