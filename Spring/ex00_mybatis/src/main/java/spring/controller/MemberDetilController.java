package spring.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

@Controller
public class MemberDetilController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/member/detail/{id}")
	public String detail(@PathVariable("id") Long id,Model model) {
		
		Member member = memberDao.selectById(id);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
//	// 예외 처리 메서드
//	@ExceptionHandler(TypeMismatchException.class)
//	public String handleTypeMismatchException(TypeMismatchException err) {
//		//return "적절한 에러페이지";
//		return "member/invalidate";
//	}
//	
//	@ExceptionHandler(MemberNotFoundException.class)
//	public String handleMemberNotFoundException(MemberNotFoundException err) {
//		//return "적절한 에러페이지";
//		err.printStackTrace();
//		err.getMessage();
//		return "member/noMember";
//	}
	
	
	
}







