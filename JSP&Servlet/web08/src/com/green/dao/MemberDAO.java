package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.MemberVO;


public class MemberDAO { // db연결용 클래스

	// 싱글턴 구성
	private MemberDAO() {
	};

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getInstance() {
		return dao;
	}

	// ------------------------------------------------

	// 데이터베이스 연결 객체를 소환하는 메서드
	private Connection getConnection() throws Exception {
		Context initContext = new InitialContext(); // javax.naming
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle"); // javax.sql
		Connection conn = ds.getConnection();

		return conn;
	}

	// ----------------------------------------------------
	// 1. 아이디와 비밀번호를 통해서 사용자 인증 처리하는 메서드
	public int userCheck(String userid, String userpwd) {

		int result = -1;

		String sql = "SELECT userpwd FROM member WHERE userid = ?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println("정상적으로 통과");
		try {

			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, userid);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// 아이디는 있는 경우
				if (rs.getString("userpwd") != null && rs.getString("userpwd").equals(userpwd)) {
					// 비밀번호가 일치하는 경우 => 로그인 성공
					result = 1;
				} else {
					// 비밀번호가 null이거나, 비밀번호가 일치하지 않는 경우
					result = 0;
				}

			} else {
				// 아이디가 없는 경우
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;

	}

// ----------------------------------------------------------------------------------
	// 아이디를 가지고 회원 정보를 읽어오는 메서드
	public MemberVO getMember(String userid) {
		MemberVO mVo = null;

		String sql = "SELECT * FROM member WHERE userid=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, userid);

			rs = psmt.executeQuery();

			if (rs.next()) {
				mVo = new MemberVO();

				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mVo;
	}

	// ----------------------------------------------------------------------------------
	// 수정된 회원 정보를 데이터베이스에 업데이트 하기 위한 메서드
	public int updateMember(MemberVO mVo) {
		int result = -1;

		String sql = "UPDATE member SET userpwd=?,email=?,phone=?,admin=? WHERE userid=?";

		Connection conn = null;
		PreparedStatement psmt = null; // 물음표를 채우기위한

		try {

			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getUserpwd()); // 1번째 물음표
			psmt.setString(2, mVo.getEmail()); // 2번째 물음표
			psmt.setString(3, mVo.getPhone()); // 3번째 물음표
			psmt.setInt(4, mVo.getAdmin()); // 4번째 물음표
			psmt.setString(5, mVo.getUserid()); // 5번째 물음표

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// ===========================================================
	// 회원 가입을 위한 메서드

	public int insertMember(MemberVO mVo) {
		int result = -1;
//	   System.out.println("이름 : " + mVo.getName());
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mVo.getName());
			psmt.setString(2, mVo.getUserid());
			psmt.setString(3, mVo.getUserpwd());
			psmt.setString(4, mVo.getEmail());
			psmt.setString(5, mVo.getPhone());
			psmt.setInt(6, mVo.getAdmin());

			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

// -------------------------------------------------------------------------------------------
	// 아이디 중복 체크를 위한 메서드

	public int confirmId(String userid) {
		int result = -1;

		String sql = "SELECT userid FROM member WHERE userid=?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null; // 셀렉트문을 사용할때 사용

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, userid);

			rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
				// 아이디가 존재 => 아이디를 사용할 수 없다
			} else {
				result = -1;
				// 아이디가 없다 => 아이디를 사용할 수 있다.
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteMember(MemberVO mVo) {
		int result = -1;

		String sql = "DELETE FROM member WHERE userid=?";

		Connection conn = null;
		PreparedStatement psmt = null; // 물음표를 채우기위한

		try {

			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getUserid()); // 1번째 물음표

			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getAdmin(String userid) {
		int admin1 = -1;

		String sql = "SELECT admin FROM member WHERE userid=?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, userid);

			rs = psmt.executeQuery();

			if (rs.next()) {
				
				admin1 = rs.getInt("admin");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return admin1; // 1(관리자) or 0(회원) or -1(아이디 불일치)
	}

// 전체 데이터 읽어오는 메서드
	public List<MemberVO> selectMemberAll() {
		List<MemberVO> list = new ArrayList<>();

		String sql = "SELECT * FROM member ORDER BY name";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberVO mVo = new MemberVO();

				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));

				list.add(mVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
