package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main04 {

	public static void main(String[] args) {
		// 2 . @Aspect 어노테이션을 이용해서 Aspect를 설정하는 방법
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx02.xml");
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		
		long result = impeCalc.factorial(10);
		
		System.out.println("10! 계산 결과 : "+result);
	}

}
