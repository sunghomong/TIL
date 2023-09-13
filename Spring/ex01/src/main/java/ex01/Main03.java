package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main03 {

	public static void main(String[] args) {
		// 스프링 컨테이너가 가지는 빈의 특징 => 하나의 인스턴스를 돌려가며 쓴다!
		//							    => 싱글턴 패턴
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Greeter gt1 = ctx.getBean("greeter",Greeter.class);
		Greeter gt2 = ctx.getBean("greeter",Greeter.class);

		System.out.println("(gt1==gt2) = "+(gt1==gt2)); // 두객체는 같은 객체 : true
		
		
		
	}

}
