package test;

public class PwdChk {
	
	public PwdStatus pwdChk(String password) { 
		// 비밀번호를 입력 받아서 비밀번호의 상태를 체크하는 메서드
//		- 비밀번호를 체크하는 메서드를 만드세요.
//		  길이는 8자리 이상, 숫자포함, 대소문자가 포함되어야 한다.
//		  조건 3가지가 모두 통과하면 Strong
//		  조건 2가지가 통과하면 normal
//		  조건 1가지만 통과하면 weak
		
		// 0. 암호가 NULL 인지 아닌지 체크
		if(password == null || password.isEmpty()) {
			return PwdStatus.INVALID;
		}
		
		int chkCount = 0; // 카운트가 많을수록 통과 개수 증가
		// 1. 대문자 미포함 체크
		boolean upperCase = true;
		for(char ch : password.toCharArray()) { // toCharArray() = 글자 하나하나 쪼개서 배열로 만듬
			if(Character.isUpperCase(ch)) {
				upperCase = false; // 대문자 존재 발견
				chkCount += 1;
				break;
			}
		}
		// 2. 8글자 미만 체크
		boolean pwdLength = true; // 8글자 미만
		if(password.length() >= 8) {
			pwdLength = false; // 8글자 이상
			chkCount += 1;
		}
		// 3. 숫자 미포함 체크
		boolean numChk = true; // 숫자 미포함
		for(char ch : password.toCharArray()) {
			if(ch >= '0' && ch <= '9') {
				numChk = false; // 숫자 포함
				chkCount += 1;
				break;
			}
		}
		// 3가지 모두 통과하지 못하는 경우
		if(upperCase && pwdLength && numChk) {
			return PwdStatus.WEAK;
		}
		
		// 두가지 조건을 통과하지 못하는 경우
		switch (chkCount) {
		case 1: return PwdStatus.WEAK;
			
		case 2: return PwdStatus.NORMAL;
		
		case 3: return PwdStatus.STRONG;
		
		default:
			break;
		}
		
		// 한가지 조건을 통과하지 못하는 경우
		
		if(upperCase) { // 대문자 미포함인 경우
			return PwdStatus.NORMAL;
		}
		if(pwdLength) { // 8글자 미만인 경우
			return PwdStatus.NORMAL;
		}
		if(numChk) { // 숫자가 미포함인 경우
			return PwdStatus.NORMAL;
		}
		// 조건이 모두 통과되는 경우
		return PwdStatus.STRONG;
	}
}
