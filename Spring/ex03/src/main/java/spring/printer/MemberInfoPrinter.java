package spring.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter {

	private MemberDao memDao;
	@Autowired   // Setter메서드도 필요없이 필드를 기준으로 알아서 적절한 객체를 주입해준다.
//	@Qualifier("chk01")
	private MemberPrinter printer;
	
	@Autowired  // 앞으로 자동 주입으로 빈 중에서 적절한 Dao 객체를 주입해준다.
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}

//	public void setPrinter(MemberPrinter printer) {
//		this.printer = printer;
//	}

	public void printMemberInfo(String email) {// 회원 한명에 대한 정보를 출력하는 메서드
//		MemberDao dao = MemberDao.getInstance();
		
		Member member = memDao.selectByEmail(email); 
	
		if(member == null) {
			System.out.println("데이터 없음 \n ");
			return;
		}
	
		printer.print(member);

	}
}






