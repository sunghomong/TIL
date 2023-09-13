package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main02 {

	public static void main(String[] args) {
		// Spring 기본코드
		//   - [대원칙] : 인스턴스는 내(spring)가 만들어줄께!!
		//               => IoC(Inversion of Control) : 제어의 역전
		
		// 1. 스프링이 관리하는 빈의 정보를 가진 파일(컨테이너 설정파일) 읽어오기
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 2. 스프링 컨테이너에 생성된 빈을 가져온다.
		Greeter gt = ctx.getBean("greeter",Greeter.class);
		
		// 3. 가져온 객체를 사용하면 됨
		System.out.println(gt.greet("고길동"));
		
		

	}

}
