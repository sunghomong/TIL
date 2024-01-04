package com.green.testcheck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.green.check.PasswordConditionCheck;
import com.green.status.PasswordStatus;

public class PasswordConditionCheckTest {
   
   PasswordConditionCheck pwdChk = new PasswordConditionCheck();
   
   // 1단계 모든 요건을 통과하는 경우 
   @Test
   public void conditionThenStrong () {
      
      String pwd1 = "ab12!@AB";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.STRONG, result);
      
      String pwd2 = "abc1!Add";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.STRONG, result);
   }
   
   // 2단계 8글자 미만인 경우
   @Test
   public void conditionLengthThenNormal () {
      
      String pwd1 = "ab12@A";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.NORMAL, result);
      
      String pwd2 = "Ab12!c";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.NORMAL, result);
   }
   
   
   // 3단계 숫자가 포함되지 않는 경우
   @Test
   public void conditionNumberThenNormal () {
      
      String pwd1 = "ab!@ABqwer";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.NORMAL, result);
      
      String pwd2 = "Ab!Zx@cD";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.NORMAL, result);
   }
   
   // 4단계 대문자를 포함하지 않는 경우  
   @Test
   public void conditionUppercaseThenNormal () {
      
      String pwd1 = "ab12!@df";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.NORMAL, result);
      
      String pwd2 = "1b!2x@c4";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.NORMAL, result);
   }
   
   // 5단계 8글자 이상이고 그 외 요건을 충족하지 않는 경우 
   @Test
   public void conditionOnlylengthThenWeak () {
      
      String pwd1 = "abcdefghi";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.WEAK, result);
      
      String pwd2 = "qwe!@zxc";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.WEAK, result);
   }
   
   // 6단계 숫자만 포함되고 그 외 요건을 충족하지 않는 경우
   @Test
   public void conditionOnlyNumThenWeak () {
      
      String pwd1 = "12345";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.WEAK, result);
      
      String pwd2 = "45!@7";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.WEAK, result);
   }
   
   // 7단계 대문자만 포함되고 그 외 요건을 충족하지 않는 겨우
   @Test
   public void conditionOnlyUppercaseThenWeak () {
      
      String pwd1 = "ABCDE";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.WEAK, result);
      
      String pwd2 = "QW@#A";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.WEAK, result);
   }
   
   // 8단계 모든 요건을 충족하지 않는 경우
   @Test
   public void noConditionThenWeak () {
      
      String pwd1 = "abc";
      PasswordStatus result = pwdChk.passwordCheck(pwd1);
      assertEquals(PasswordStatus.WEAK, result);
      
      String pwd2 = "qw#@";
      result = pwdChk.passwordCheck(pwd2);
      assertEquals(PasswordStatus.WEAK, result);
   }
   
   // 9단계 암호가 NULL이거나 공백이 입력된 경우
   @Test
   public void nullInputThenInvalid() {
      String pwd = null;
      PasswordStatus result = pwdChk.passwordCheck(pwd);
      assertEquals(PasswordStatus.INVALID, result);
   }
   
   @Test
   public void emptyInputThenInvalid() {
      String pwd = "";
      PasswordStatus result = pwdChk.passwordCheck(pwd);
      assertEquals(PasswordStatus.INVALID, result);
   }
   
}

/*
 * 애플리케이션 테스트 관리 평가
 * 시험일 : 2023년 10월 24일
 * 제한시간 : 180분
 * 훈련생명 : 조성호
 */