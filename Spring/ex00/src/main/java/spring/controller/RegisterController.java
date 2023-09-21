package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exception.AlreadyExistingMemberException;
import spring.service.MemberRegisterService;
import spring.validator.RegisterRequestValidator;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("register") // 컨트롤러 클래스 내부의 경로에서 공통된 부분을 따로 추출해서 작성 가능
public class RegisterController { // 회원 가입 기능
	
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	// http://localhost:8085/ex00/경로 -> 서블릿이 동작
	// 							web.xml, @WebServlet()
	//							=> 스프링에서는 우리가 서블릿을 만들지 않는다! -> dispatcherServlet이 동작
	
	// http://localhost:8085/ex00/register/step1 
	@RequestMapping("/step1")
	public String handlerStep1() {
		
		return "register/step1"; // /WEB-INF/views/register/step1.jsp
	}
	
	
	// http://localhost:8085/ex00/register/step2
	// RequestMapping은 Get과 Post 를 구분하지 않음 => method방식을 RequestMethod.POST => POST요청에만 반응
	// 파라미터 읽어오기
	// 1. request 객체의 파라미터를 이용한 방식 
//	@RequestMapping(value = "register/step2", method = RequestMethod.POST) // 위의 메핑과 같은 뜻 value 생략 가능 (단, 가로안에 두개 이상의 값을 넣을때는 적어야 함)
//	public String handlerStep2(HttpServletRequest request) {
//		String agreeParam = request.getParameter("agree");
//				// true, false
//		if(agreeParam == null || !agreeParam.equals("true")) {
//			
//			return "register/step1";
//		}
//		
//		return "register/step2";
//	}
	
	// 2. @RequestParam 어노테이션을 이용한 방식
	@PostMapping("/step2") // = (value = "register/step2", method = RequestMethod.POST) 단, get,post 둘다 사용할때는 위의 방식을 사용
	public String handlerStep2(@RequestParam(value = "agree", required = false, defaultValue = "false") Boolean agree,Model model) { // 장점 : 자동 형 변환 가능
		// (required = false, defaultValue = "false") = 필수 요소는 아니지만 입력값이 없을경우 false를 쓰겠습니다.
		
		if(!agree) {
			return "register/step1";
		}
		// 스프링 커스텀 폼 태그에 에러를 없애기 위해 빈 커맨드객체를 넣어주어야 한다.
		model.addAttribute("formData", new RegisterRequest());
		
		return "register/step2";
	}
	
	// 기본적인 페이지 이동방식
	// 요청 -> 컨트롤러 -> 뷰 -> 응답
	// 	==== 포워드 ====>
	
	// 리다이렉트 
	// 요청 -> 컨트롤러 -> 리다이렉트 => 요청 -> 컨트롤러 -> 뷰 -> 응답
	
	@GetMapping("/step2") // 주소창에 직접 입력해서 이동 : http://localhost:8085/ex00/register/step2 
	public String handlerStep2Get(){
		
//		return "register/step1"; // 어쨋든 주소창에는 http://localhost:8085/ex00/register/step2로 출력
		//  /WEB-INF/views/register/step1.jsp
		
		
//		return "redirect:register/step1";
		// 클라이언트에게 아래 주소로 이동하세요 -> 지시
		// http://localhost:8085/ex00/register/step1
		
		return "redirect:http://localhost:8085/ex00/register/step1"; // = redirect:register/step1
		
		// 즉 위의 기본적인 페이지 이동은 페이지는 이동이 가능하지만 주소창은 똑같게 처리 되고
		// 아래의 리다이렉트는 페이지,경로 자체가 이동 가능
	}
	
	@GetMapping("/step3")
	public String handlerStep3Get() {
		
		return "redirect:step1"; // 리다이렉트
		
		// redirect : /~~~ [원] http://localhost:8085/ex00/register/step3
		// 						=> http://localhost:8085/ex00/~~~

		// redirect : ../~~~  [원] http://localhost:8085/ex00/members/register/step3
		//   					=> http://localhost:8085/ex00/members/~~~
		
		// redirect : ~~~  [원] http://localhost:8085/ex00/register/step3
		// 						=> http://localhost:8085/ex00/register/~~~
		
		// redirect : ./~~~  [원] http://localhost:8085/ex00/register/step3
		//   					=> http://localhost:8085/ex00/register/~~~
		
		// "/"로 시작하지 않으면 @RequestMapping 경로를 기준으로 Redirect 된다. (상대 경로)
		// "redirect:" 뒤에 완전한 URL을 적는다면, 해당 URL로 Redirect 된다. (절대 경로)
		
	}
	
	
	
	
//	@PostMapping("/step3")
//	public String handlerStep3(
//			@RequestParam("email") String email,
//			@RequestParam("name") String name,
//			@RequestParam("password") String password,
//			@RequestParam("confirmPassword") String confirmPassword) {
//		
//		// 폼태그에서 데이터 가져오기
//		// 1. HttpServletRequest request .getParamater("이름");
//		// 2. @RequestParam("이름") String 변수명  => 형변환도 필요하면 알아서 진행
//		
//		
//		return "register/step3";
//	}
	
	
	@PostMapping("/step3")	// => 커맨드 객체   => 외부에서 사용할 이름[request.setAttribute("formData",~~~)]
	public String handlerStep3(@ModelAttribute("formData") RegisterRequest regReq,Errors error) {
		// 여러 데이터를 한꺼번에 전달 받는 방식
		// 전제조건 : 폼에서 사용한 이름과 객체의 필드명이 일치하는 경우
		//		=> 폼에서 사용한 이름과 set메서드의 필드명이 일치하는 경우
		
//		RegisterRequest객체를 검증 -> 에러
		new RegisterRequestValidator().validate(regReq, error);
		
		// 에러 발생 여부는 에러 객체를 통해서 확인
		if(error.hasErrors()) {
			// hasErrors메서드가 true라면 에러가 있었다!
			return "register/step2";
		}
		
		
		try {
			
			// MemberRegisterService가 필요함
			// 1) private MemberRegisterService memberRegisterService; 필드 생성
			// 2) @Autowired로 의존 주입 => 자동 주입을 지원하기 위한 기능 <context:annotation-config/> 적용
			
			memberRegisterService.regist(regReq); // 회원 가입 기능 동작
			
			return "register/step3";
		} catch (AlreadyExistingMemberException e) {
			error.rejectValue("email", "duplicate"); // 이메일 중복 에러
			return "register/step2";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
