package spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spring.intercepter.AuthCheckIntercepter;

@Configuration // 스프링 설정 => 빈
@EnableWebMvc // [annotation-driven]
public class MvcConfig implements WebMvcConfigurer {
	// WebMvcConfigurer 인터페이스 구현 : mvc:~~~
	
	// [default-servlet-handler]
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// [view-resolvers]
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp"); jsp 생략 가능
		registry.jsp().prefix("/WEB-INF/views/");
	}

	// [view-controller]
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");;
		registry.addViewController("/").setViewName("main");;
	}
	
	// 메시지.프로퍼티를 읽어올 빈 객체 설정
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource msgSrc = new ResourceBundleMessageSource();
		msgSrc.setDefaultEncoding("UTF-8");
		msgSrc.setBasenames("message.label");
		return msgSrc;
	}
	
	// 인터셉터
	// 1. 인터셉터에서 사용할 빈
	@Bean
	public AuthCheckIntercepter authCheckIntercepter() {
		return new AuthCheckIntercepter();
	}

	
	// 2. 인터셉터에서 사용할 빈을 어디에 적용할 것인가?
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckIntercepter()).addPathPatterns("/edit/**");
//		registry.addInterceptor(적용할 인터셉터 빈).addPathPatterns("주소창 경로");
	}
	
	
	
}























