package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.config.JavaMainConfig;
import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaConfig.class);
//				new AnnotationConfigApplicationContext(ConfigPart1.class,ConfigPart2.class);
//				new AnnotationConfigApplicationContext(ConfigPartMain.class);
//				new AnnotationConfigApplicationContext(JavaMainConfig.class);
				new GenericXmlApplicationContext("classpath:main-config.xml");
				
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc",MemberRegisterService.class);
		
		MemberInfoPrinter info = 
				ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq);
		
		info.printMemberInfo("hong@naver.com");
	}

}
