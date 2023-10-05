package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import spring.vo.Member;

@Repository
public class MemberDao2 { // DB 연결해서 쿼리를 보내고 데이터를 받기 위한 클래스
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao2(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// SELECT 매핑 규칭
	private RowMapper<Member> mapper = 
			new RowMapper<Member>() {

				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = 
							Member.builder()
								  .id(rs.getLong("id"))
								  .name(rs.getString("name"))
								  .email(rs.getString("email"))
								  .password(rs.getString("password"))
								  .registerDate(rs.getTimestamp("regdate"))
								  .build();	
					return member;
				}
			};
	
	
	public List<Member> selectAll(){
		String sql = "SELECT * FROM members ORDER BY id ASC";
		List<Member> list = jdbcTemplate.query(sql,mapper);
		return list;
	}



	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM members WHERE email=?";		
		List<Member> list = jdbcTemplate.query(sql,mapper,email);	
		return list.isEmpty()?null:list.get(0);
	}
	
	public int count() { // 하나의 결과만 반환하는 경우
		String sql = "SELECT COUNT(*) FROM members";
		
		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class );
  		return cnt;
	}
	public void update(Member member) {
		String sql = "UPDATE members SET name=?, password=? WHERE email=?";
		
		int cnt = jdbcTemplate.update(sql,
							member.getName(), 
							member.getPassword(), 
							member.getEmail());
		System.out.println("update로 변경된 데이터 개수 : "+cnt); 
	}

	public void insert(Member member) { 
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO members "
				+ "   VALUES(members_seq.nextval,?,?,?,?)";
		
		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement psmt = con.prepareStatement(sql,new String[] {"id"});
				
				psmt.setString(1, member.getEmail());
				psmt.setString(2, member.getPassword());
				psmt.setString(3, member.getName());
				psmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return psmt;
			}
		}, keyHolder);
		
		Number keyNum = keyHolder.getKey();
		System.out.println("새로 넣게될 시퀀스값 : "+keyNum.longValue());
	
		System.out.println("입력된 데이터 개수 : "+cnt);
	}
	
	
	// 가입일 기준으로 회원 검색하는 메서드
	public List<Member> selectByRegdate(Date from, Date to){ 
		
		String sql = " SELECT * FROM members   "
				+ "    WHERE regdate BETWEEN ? AND ?   "
				+ "    ORDER BY regdate ASC  ";
		
		List<Member> result = jdbcTemplate.query(sql, mapper,from, to);
		
		return result;
	}
	

}





