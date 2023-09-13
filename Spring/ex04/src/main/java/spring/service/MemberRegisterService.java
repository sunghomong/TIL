package spring.service;

import java.util.Date;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService { // 회원 가입 기능
	
	private MemberDao dao; // = new MemberDao();
	
	// 생성자를 통해서 외부로 부터 만들어진 인스턴스를 주입 받는다.
	public MemberRegisterService(MemberDao dao) {
		this.dao = dao;
	}

	
	
	
	public void regist(RegisterRequest req) { // 회원 가입 기능 메서드
		Member member = dao.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new AlreadyExistingMemberException("이메일 중복");
		}
		
		Member newMember = 
				new Member(req.getEmail(),req.getPassword(),req.getName(),new Date());
		
		dao.insert(newMember);
		
	}

	
	
	
}
