package spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import spring.dao.MemberDao;

@Configuration
@EnableTransactionManagement // [annotation-driven transaction-manager]
public class MemberConfig {
	
	@Bean  // [빈] DB 연결을 위한 DataSource
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
			ds.setDriverClass("oracle.jdbc.OracleDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUser("HR");
		ds.setPassword("1234");
		
		return ds;
	}
	
	// [빈] 트랜젝션 매니저
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager txMgr = new DataSourceTransactionManager();
		txMgr.setDataSource(dataSource());
		return txMgr;
	}
	
	// [빈] 쿼리 전달을 도와주는 객체 : JdbcTemplate
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	// [빈] 실제 DB 연결을 처리하기 위한 클래스 DAO
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(jdbcTemplate());
	}
	
}
























