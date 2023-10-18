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


public class MemberDAO { // db����� Ŭ����

	// �̱��� ����
	private MemberDAO() {
	};

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getInstance() {
		return dao;
	}

	// ------------------------------------------------

	// �����ͺ��̽� ���� ��ü�� ��ȯ�ϴ� �޼���
	private Connection getConnection() throws Exception {
		Context initContext = new InitialContext(); // javax.naming
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle"); // javax.sql
		Connection conn = ds.getConnection();

		return conn;
	}

	// ----------------------------------------------------
	// 1. ���̵�� ��й�ȣ�� ���ؼ� ����� ���� ó���ϴ� �޼���
	public int userCheck(String userid, String userpwd) {

		int result = -1;

		String sql = "SELECT userpwd FROM member WHERE userid = ?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		System.out.println("���������� ���");
		try {

			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, userid);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// ���̵�� �ִ� ���
				if (rs.getString("userpwd") != null && rs.getString("userpwd").equals(userpwd)) {
					// ��й�ȣ�� ��ġ�ϴ� ��� => �α��� ����
					result = 1;
				} else {
					// ��й�ȣ�� null�̰ų�, ��й�ȣ�� ��ġ���� �ʴ� ���
					result = 0;
				}

			} else {
				// ���̵� ���� ���
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
	// ���̵� ������ ȸ�� ������ �о���� �޼���
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
	// ������ ȸ�� ������ �����ͺ��̽��� ������Ʈ �ϱ� ���� �޼���
	public int updateMember(MemberVO mVo) {
		int result = -1;

		String sql = "UPDATE member SET userpwd=?,email=?,phone=?,admin=? WHERE userid=?";

		Connection conn = null;
		PreparedStatement psmt = null; // ����ǥ�� ä�������

		try {

			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getUserpwd()); // 1��° ����ǥ
			psmt.setString(2, mVo.getEmail()); // 2��° ����ǥ
			psmt.setString(3, mVo.getPhone()); // 3��° ����ǥ
			psmt.setInt(4, mVo.getAdmin()); // 4��° ����ǥ
			psmt.setString(5, mVo.getUserid()); // 5��° ����ǥ

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
	// ȸ�� ������ ���� �޼���

	public int insertMember(MemberVO mVo) {
		int result = -1;
//	   System.out.println("�̸� : " + mVo.getName());
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
	// ���̵� �ߺ� üũ�� ���� �޼���

	public int confirmId(String userid) {
		int result = -1;

		String sql = "SELECT userid FROM member WHERE userid=?";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null; // ����Ʈ���� ����Ҷ� ���

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, userid);

			rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
				// ���̵� ���� => ���̵� ����� �� ����
			} else {
				result = -1;
				// ���̵� ���� => ���̵� ����� �� �ִ�.
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
		PreparedStatement psmt = null; // ����ǥ�� ä�������

		try {

			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getUserid()); // 1��° ����ǥ

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

		return admin1; // 1(������) or 0(ȸ��) or -1(���̵� ����ġ)
	}

// ��ü ������ �о���� �޼���
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
