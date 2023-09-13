package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
@Import(ConfigPartSub.class)
//@Import({ConfigPartSub.class,ConfigPart2.class})
public class ConfigPartMain {
	
	@Bean  // 빈으로 역할을 한다.
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // 생성자 주입
	}
}
