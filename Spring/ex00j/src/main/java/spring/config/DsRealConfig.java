package spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@Profile("real") // real 프로필이 적용된 설정 클래스
public class DsRealConfig {
	
	@Bean  // [빈] DB 연결을 위한 DataSource
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
			ds.setDriverClass("oracle.jdbc.OracleDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUser("GREEN99");
		ds.setPassword("1234");
		
		return ds;
	}
}
