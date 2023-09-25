package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.controller.RegisterController;

@Configuration // 스프링 설정
@ComponentScan(basePackages = {"spring.controller","spring.service","spring.commonException"}) // 지정된 패키지에 필요한 모든 클래스를 빈으로 읽어들이는 기능
public class ControllerConfig {
	
	// 필요한 빈들을 등록
	// 자동주입이 알아서 지원 : annotation-config 없어도 됨
	// 생성자를 통한 자동주입 지원 X
	
	// 수동으로 직접 빈을 지정할 필요가 있는 경우에 빈을 등록해서 사용
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}
	
}
