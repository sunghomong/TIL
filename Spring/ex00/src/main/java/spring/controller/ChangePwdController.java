package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.ChangePasswordService;
import spring.validator.ChangePwdCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.ChangePwdCommand;

@Controller
@RequestMapping("edit/changePassword")
public class ChangePwdController {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping
	public String form(Model model) {
		model.addAttribute("changePwdCommand", new ChangePwdCommand());
		
		return "edit/changePwdForm";
	}
	
	@PostMapping
	public String submmited(ChangePwdCommand changePwdCommand, Errors error, HttpSession session) {
		// 1. 검증
		new ChangePwdCommandValidator().validate(changePwdCommand, error);
		
		if(error.hasErrors()) {
			return "edit/changePwdForm";
		}
		
		// 2. 이메일정보를 알아오기 위해 세션에 저장된 로그인 정보를 알아오기
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		try {
			
			changePasswordService.changePassword(authInfo.getEmail(), changePwdCommand.getCurrentPassword() , changePwdCommand.getNewPassword());
			
			return "edit/ChangedPwd";
		} catch (IdPasswordNotMatchingException e) {
			// 입력한 기존의 비밀번호와 저장된 비밀번호가 다른 경우
			error.rejectValue("currentPassword", "notMatching");
			
			return "edit/changePwdForm";
		}
		
	}
	
}















