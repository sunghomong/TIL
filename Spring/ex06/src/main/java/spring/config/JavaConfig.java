package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aspect.ExeTimeAspect2;
import spring.calc.Calculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

@Configuration
@EnableAspectJAutoProxy   //<aop:aspectj-autoproxy /> : @Aspect 객체를 자동으로 찾아서 적용해 준다!
public class JavaConfig {
	// appCtx02.xml이랑 유사하다.

	// 대상 객체를 빈으로 등록
	@Bean
	public Calculator impeCalc() {
		return new ImpeCalculator();
	}
	
	@Bean
	public Calculator recCalc() {
		return new RecCalculator();
	}
	
	// 프록시 객체(공통 기능)도 빈으로 등록
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
	
	
	
	
	
}
