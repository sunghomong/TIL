package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect2 {
	// 공통 기능 + Aspect설정
	// 1. 공통 기능을 적용할 대상(핵심기능)이 무엇인가?
	@Pointcut("execution(public * spring.calc..*(..))")
	private void factorialMethod() {}
	//            이름은 아무거나
	
	// 2. 공통 기능을 언제 적용할 것인가?
	@Around("factorialMethod()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		
		long start = System.nanoTime();
		
		Object result = joinPoint.proceed(); 

		long end = System.nanoTime();
		
		System.out.println("걸린 시간 : "+(end-start));
		
		return result;
		
	}

}
