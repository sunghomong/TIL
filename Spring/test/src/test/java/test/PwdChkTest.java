package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PwdChkTest {
	
	@Test
	public void chk01() { 
		// 3가지 조건을 만족하는 비밀번호를 넣었을 때 결과가 잘 나오는가?
		PwdChk pwdChk = new PwdChk();
		String pwd = "qw12!@ZX"; // 기대하는 결과는 STRONG
		PwdStatus result = pwdChk.pwdChk(pwd);
	
//		if(result!=null && result == PwdStatus.STRONG) {
//			System.out.println(pwd + ": 테스트 성공");
//		}else {
//			System.out.println(pwd + ": 테스트 실패");
//		}
		
		assertEquals(PwdStatus.STRONG, result);
					// 기대값				실제 결과
	}
	
	@Test
	public void chk02() {
		// 대문자가 포함되지 않는 경우 => 기대하는 결과 : NORMAL 
		PwdChk pwdChk = new PwdChk();
		String pwd = "qw12!@zx"; // 기대하는 결과는 NORMAL
		PwdStatus result = pwdChk.pwdChk(pwd);
		
//		if(result!=null && result == PwdStatus.NORMAL) {
//			System.out.println(pwd + ": 테스트 성공");
//		}else {
//			System.out.println(pwd + ": 테스트 실패");
//		}
		assertEquals(PwdStatus.NORMAL, result);
	}
	@Test
	public void chk03() {
		// 8글자 미만인 경우 => 기대하는 결과 : NORMAL 
		PwdChk pwdChk = new PwdChk();
		String pwd = "qw12ZX"; // 기대하는 결과는 NORMAL
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.NORMAL, result);
	}
	
	@Test
	public void chk04() {
		// 숫자가 포함되지 않는 경우 => 기대하는 결과 : NORMAL 
		PwdChk pwdChk = new PwdChk();
		String pwd = "qwpo*&ZX"; // 기대하는 결과는 NORMAL
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.NORMAL, result);
	}
	
	@Test
	public void chk05_1() {
		// 비밀번호가 애초에 입력이 안되거나 공백문자로 입력된 경우
		// 기대하는 결과 : INVALID
		PwdChk pwdChk = new PwdChk();
		String pwd = null; // 기대하는 결과는 INVALID
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.INVALID, result);
	}
	
	@Test
	public void chk05_2() {
		// 비밀번호가 애초에 입력이 안되거나 공백문자로 입력된 경우
		// 기대하는 결과 : INVALID
		PwdChk pwdChk = new PwdChk();
		String pwd = ""; // 기대하는 결과는 INVALID
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.INVALID, result);
	}
	@Test
	public void chk06() {
		// 대문자만 포함되는 포함 => 기대하는 결과 : WEAK 
		// 숫자 X , 길이 8글자 미만
		PwdChk pwdChk = new PwdChk();
		String pwd = "pwpoZX"; // 기대하는 결과는 WEAK
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.WEAK, result);
	}
	
	@Test
	public void chk07() {
		// 숫자만 포함 => 기대하는 결과 : WEAK 
		// 대문자X , 길이 8글자 미만
		PwdChk pwdChk = new PwdChk();
		String pwd = "pwpo88"; // 기대하는 결과는 WEAK
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.WEAK, result);
	}
	@Test
	public void chk08() {
		// 숫자만 포함 => 기대하는 결과 : WEAK
		// 숫자X, 대문자X
		PwdChk pwdChk = new PwdChk();
		String pwd = "qwerasdf"; // 기대하는 결과는 WEAK
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.WEAK, result);
	}
	@Test
	public void chk09() {
		// 3가지 조건을 모두 통과하지 못하는 경우
		PwdChk pwdChk = new PwdChk();
		String pwd = "qwerasdf"; // 기대하는 결과는 WEAK
		PwdStatus result = pwdChk.pwdChk(pwd);
		assertEquals(PwdStatus.WEAK, result);
	}
}
