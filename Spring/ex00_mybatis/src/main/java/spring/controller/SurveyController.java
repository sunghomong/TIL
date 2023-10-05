package spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.survey.AnsweredData;
import spring.survey.Question;

@Controller      // @Controller => HTML,JSP응답   // @RestController  => 데이터(JSON) 응답
@RequestMapping("/survey")
public class SurveyController {
	
	private List<Question> createQuestion(){ // 설문 문제를 만들기위한 메서드
		Question q1 = new Question(
				"당신의 역할은 무엇입니까?", 
				Arrays.asList("백엔드","프론트","풀스택"));
		Question q2 = new Question(
				"많이 사용하는 개발 도구는 무엇입니까?", 
				Arrays.asList("Eclipse","IntelliJ","NetBeans"));		
		Question q3 = new Question(
				"하고 싶은 말을 적어 주세요?");
		
		return Arrays.asList(q1,q2,q3);
	}
	
//   - 새로운 방식
//	@GetMapping
//	public String form(Model model) {// 설문조사 폼페이지로 이동
//		
//		// 질문지 생성
//		List<Question> questions = createQuestion();
//		
//		// 질문지를 폼페이지로 넘겨주어야함  => Model
//		//request.setAttribute("questions",questions);
//		model.addAttribute("questions", questions);
//		// 컨트롤러에서 JSP로 데이터를 보낼때 Model객체를 사용한다.
//		
//		return "survey/surveyForm";
//	}

//    -구 방식  ModelAndView
	@GetMapping
	public ModelAndView form() {
		// 질문지 생성
		List<Question> questions = createQuestion();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("questions",questions); // Model의 역할 : 프론트로 보낼 데이터 저장하는 기능
		mav.setViewName("survey/surveyForm"); // View의 역할 : 프론트로 보낼 뷰페이지 경로및 파일명
		
		return mav;
	}
	

	
	@PostMapping      // 커맨드객체를 submitted에 넘겨준 적이 없다면 자동으로 스프링 넘겨준다. => answeredData
	public String submit(AnsweredData data) { // 설문조사 답안 받아서 처리
		
		
		return "survey/submitted";
	}
	
}






