package com.green.check;

import com.green.status.PasswordStatus;

public class PasswordConditionCheck {
	
	public PasswordStatus passwordCheck(String password) { 
		
		
		
		// 0. 암호가 NULL 인지 아닌지 체크
		if(password == null || password.isEmpty()) {
			return PasswordStatus.INVALID;
		}
		
		boolean pwdLength = (password.length() < 8); // 8글자 미만 체크
		boolean numChk = true; // 숫자 미포함
		boolean upperCase = true;
		
		for(char ch : password.toCharArray()) {
			if(Character.isUpperCase(ch)) { // 대문자 미포함 체크
				upperCase = false; // 대문자 존재 발견
			}
			if(ch >= '0' && ch <= '9') {
				numChk = false; // 숫자 포함
			}
		}
		
		int chkCnt = 0; // 만족 못시킬시 하나씩 증가
		
		if(upperCase) {
			chkCnt += 1;
		}
		if(pwdLength) {
			chkCnt += 1;
		}
		if (numChk) {
			chkCnt += 1;
		}
		
		
		return chkCnt ==3 ? PasswordStatus.WEAK : // 조건 모두 불만족시
			chkCnt ==2 ? PasswordStatus.WEAK : // 조건 1개 만족시
				chkCnt == 1 ? PasswordStatus.NORMAL :  // 조건 2개 만족시
				PasswordStatus.STRONG ; // 조건 모두 만족시
	}
}


//애플리케이션 테스트 관리 평가
//시험일 : 2023년 10월 24일
//제한시간 : 180분
//훈련생명 : 조성호