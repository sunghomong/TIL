package spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DsNestedConfig {
	
//	@Value("${db.driver}")
//	private static String driver;
//	@Value("${db.real.jdbcUrl}")
//	private static String realJdbcUrl;
//	@Value("${db.real.user}")
//	private static String realUser;
//	@Value("${db.real.password}")
//	private static String realPassoword;
//	@Value("${db.dev.jdbcUrl}")
//	private static String devJdbcUrl;
//	@Value("${db.dev.user}")
//	private static String devUser;
//	@Value("${db.dev.password}")
//	private static String devPassoword;

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		configurer.setLocation(new ClassPathResource("message/db.properties"));
		
		return configurer;
	}
	
	@Configuration
	@Profile("real")
	public static class DataSourceReal {
		
		@Value("${db.driver}")
		private String driver;
		@Value("${db.real.jdbcUrl}")
		private String realJdbcUrl;
		@Value("${db.real.user}")
		private String realUser;
		@Value("${db.real.password}")
		private String realPassoword;
		
		@Bean // [빈] DB 연결을 위한 DataSource
		public DataSource dataSource() {
			ComboPooledDataSource ds = new ComboPooledDataSource();

			try {
				ds.setDriverClass(driver);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			ds.setJdbcUrl(realJdbcUrl);
			ds.setUser(realUser);
			ds.setPassword(realPassoword);

			return ds;
		}
	}

	@Configuration
	@Profile("dev")
	public static class DataSourceDev {
		
		@Value("${db.driver}")
		private String driver;
		@Value("${db.dev.jdbcUrl}")
		private String devJdbcUrl;
		@Value("${db.dev.user}")
		private String devUser;
		@Value("${db.dev.password}")
		private String devPassoword;
		
		@Bean // [빈] DB 연결을 위한 DataSource
		public DataSource dataSource() {
			ComboPooledDataSource ds = new ComboPooledDataSource();

			try {
				ds.setDriverClass(driver);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			ds.setJdbcUrl(devJdbcUrl);
			ds.setUser(devUser);
			ds.setPassword(devPassoword);

			return ds;
		}
	}
}
