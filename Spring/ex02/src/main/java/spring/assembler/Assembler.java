package spring.assembler;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Assembler {  // 객체 조립기
	
	private MemberDao dao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.dao = new MemberDao();
		this.regSvc = new MemberRegisterService(dao); // <= 주입
		this.pwdSvc = new ChangePasswordService();
		this.pwdSvc.setDao(dao);  //  <= setter을 통한 주입
	}
	public MemberDao getDao() {
		return dao;
	}
	public MemberRegisterService getRegSvc() {
		return regSvc;
	}
	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
	
	

}
