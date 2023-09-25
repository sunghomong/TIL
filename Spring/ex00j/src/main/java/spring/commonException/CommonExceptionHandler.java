package spring.commonException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spring.exception.MemberNotFoundException;

@ControllerAdvice("spring")
public class CommonExceptionHandler { // 예외 전용 클래스
	
	// 예외 처리 메서드
		@ExceptionHandler(TypeMismatchException.class) // id에 숫자가 아닌 값을 넣을 때 발생할 에러
		public String handleTypeMismatchException(TypeMismatchException err) {
//			return "적절한 에러페이지";
			return "error/invalidate";   
		}
		
		@ExceptionHandler(MemberNotFoundException.class) // id에 존재하지 않는 번호
		public String handleMemberNotFoundException(MemberNotFoundException err) {
//			return "적절한 에러페이지";
			err.printStackTrace();
			err.getMessage();
			return "error/noMember"; 
		}
		@ExceptionHandler(RuntimeException.class) // 보통의 대부분의 예외를 처리할 메서드
		public String handleRuntimeException(RuntimeException err) {
//			return "적절한 에러페이지";
			return "error/commonException";   
		}
}
