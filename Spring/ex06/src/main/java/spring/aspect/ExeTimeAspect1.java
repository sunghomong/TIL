package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExeTimeAspect1 { // POJO기반의 공통기능을 가진 클래스
	
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{ // 공통(부가) 기능을 작성할 메서드 [범용->아무 이름이나 써도 됨]
						// 핵심 기능을 가진 객체에 대한 모든 정보
		
		long start = System.nanoTime();
		
		Object result = joinPoint.proceed(); //핵심 기능을 호출하는 메서드
					// 핵심기능을 호출하기 위해서 필요한 정보 : 메서드이름, 반환타입, 매개데이터, 매개타입, 순서
		
		long end = System.nanoTime();
		
		System.out.println("걸린 시간 : "+(end-start));
		
		return result;
		
	}
}
