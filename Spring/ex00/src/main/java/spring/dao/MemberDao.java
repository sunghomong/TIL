package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.vo.Member;

public class MemberDao { // DB 연결해서 쿼리를 보내고 데이터를 받기 위한 클래스

	private JdbcTemplate jdbcTemplate;

//	public MemberDao(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public List<Member> selectAll() {

		// jdbcTemplate을 사용하는데 중요한 요소
		// 1. 정보를 알아올 쿼리문
		// 2. 읽어온 정보를 옮겨 담을 규칙을 지정한 Mapper
		// Mapper를 만드는 방법 : 익명 구현 객체
		// 3. 정보를 담을 줄 List

		// List<Member> list = jdbcTemplate.query(sql, Mapper규칙, 매개값1, 매개값2...);
		// return list.get(0);

		String sql = "SELECT * FROM members ORDER BY id ASC";

		// 1. 인터페이스를 구현한 객체를 매개값으로 넣어줌
//		List<Member> list = jdbcTemplate.query(sql, new MapperSqlToMember());

		// 2. 인터페이스를 통한 익명 구현 객체를 매개값으로 넣어줌
//		List<Member> list = jdbcTemplate.query(sql,new RowMapper<Member>() {
//													// 익명 구현 객체
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"),
//						rs.getTimestamp("regdate"));
//				member.setId(rs.getLong("id"));
//				
//				return member;
//			}
//		});

		// 3. 람다식을 매개값으로 넣어줌
		List<Member> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"),
					rs.getTimestamp("regdate"));
			member.setId(rs.getLong("id"));

			return member;
		});

		return list;
	}


	public Member selectByEmail(String email) {
		// jdbcTemplate을 사용하는데 중요한 요소
		// 1. 정보를 알아올 쿼리문
		// 2. 읽어온 정보를 옮겨 담을 규칙을 지정한 Mapper
		// Mapper를 만드는 방법 : 익명 구현 객체
		// 3. 정보를 담을 줄 List

		// List<Member> list = jdbcTemplate.query(sql, Mapper규칙, 매개값1, 매개값2...);
		// return list.get(0);
		String sql = "SELECT * FROM members WHERE email=?";

		List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"),
						rs.getTimestamp("regdate"));
				member.setId(rs.getLong("id"));

				return member;
			}
		}, email);

//		return list.get(0);

		return list.isEmpty() ? null : list.get(0);

	}

	public int count() { // 하나의 결과만 반환하는 경우
		String sql = "SELECT COUNT(*) FROM members";

		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class);
		return cnt;
	}

//	public void insert(Member member) {
//
//		String sql = "INSERT INTO members" + "   VALUES(members_seq.nextval,?,?,?,?)";
//
//		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
//			// 미완성 쿼리문을 수동으로 완성시키는 기능
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				//
//
//				PreparedStatement psmt = con.prepareStatement(sql);
//
//				psmt.setString(1, member.getEmail());
//				psmt.setString(2, member.getPassword());
//				psmt.setString(3, member.getName());
//				psmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
//
//				return psmt;
//			}
//		});
//		System.out.println("입력된 데이터 개수 : " + cnt);
//
//	}

	public void update(Member member) {
		// 보다 간결하게 쿼리를 완성시켜 봅시다.
		String sql = "UPDATE members SET name=?,password=? WHERE email=?";

		int cnt = jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getEmail());

		System.out.println("update로 변경된 데이터 개수 : " + cnt);

	}

	public void insert(Member member) { // insert 전에 시퀀스 값 미리 알아오기
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO members" + "   VALUES(members_seq.nextval,?,?,?,?)";

		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
										// 미완성 쿼리문을 수동으로 완성시키는 기능
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//
				
				PreparedStatement psmt = con.prepareStatement(sql,new String[] {"id"});

				psmt.setString(1, member.getEmail());
				psmt.setString(2, member.getPassword());
				psmt.setString(3, member.getName());
				psmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));

				return psmt;
			}
		}, keyHolder); // PreparedStatementCreator, keyHolder
		
		Number KeyNum = keyHolder.getKey();
		System.out.println("새로 넣게될 시퀀스 값 : " + KeyNum.longValue());
		
		System.out.println("입력된 데이터 개수 : " + cnt);

	}

//	public Collection<Member> selectAll() {
//
//		return null;
//	}

}
