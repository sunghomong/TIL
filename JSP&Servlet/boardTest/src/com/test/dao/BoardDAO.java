package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.test.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		return dao;
	}

	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";

		String sql = "SELECT * FROM boardTbl ORDER BY boardNum DESC";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, uId, uPwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNum(rs.getInt("boardNum"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardContent(rs.getString("boardContent"));
				board.setBoardCount(rs.getInt("boardCount"));
				board.setBoardRegDate(rs.getTimestamp("boardRegDate"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public void plusCountByNum(int boardNum) {

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";

		String sql = "UPDATE boardTbl SET boardCount = boardCount + 1 WHERE boardNum= " + boardNum;

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uId, uPwd);
			stmt = conn.createStatement();

			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public BoardVO getBoardInfoByNum(int boardNum) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";

		String sql = "SELECT * FROM boardTbl WHERE boardNum= " + boardNum;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO board = new BoardVO();
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uId, uPwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				board.setBoardNum(rs.getInt("boardNum"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardContent(rs.getString("boardContent"));
				board.setBoardCount(rs.getInt("boardCount"));
				board.setBoardRegDate(rs.getTimestamp("boardRegDate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return board;
	}

	public void deleteBoard(int boardNum) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";

		String sql = "DELETE FROM boardTbl WHERE boardNum=?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uId, uPwd);
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, boardNum);

			psmt.executeUpdate();
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

	}

	public BoardVO getBoardByNum(int boardNum) {
		BoardVO board = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";

		String sql = "SELECT * FROM boardTbl WHERE boardNum = " + boardNum;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uId, uPwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				board = new BoardVO();

				board.setBoardNum(rs.getInt("boardNum"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardContent(rs.getString("boardContent"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardCount(rs.getInt("boardCount"));
				board.setBoardRegDate(rs.getTimestamp("boardRegDate"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	public void updateBoard(BoardVO board) {

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "HR";
		String uPwd = "1234";

		String sql = "UPDATE boardTbl SET boardWriter=?, boardTitle=?, boardContent=? WHERE boardNum=?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uId, uPwd);
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, board.getBoardWriter());
			psmt.setString(2, board.getBoardTitle());
			psmt.setString(3, board.getBoardContent());
			psmt.setInt(4, board.getBoardNum());

			psmt.executeUpdate();
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

	}

	public void insertBoard(BoardVO board) {

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "HR";
		String password = "1234";

		String sql = " INSERT INTO boardTbl VALUES (boardTbl_seq.nextval, ?, ?, ?,0,SYSDATE) ";

		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, board.getBoardTitle());
			ptmt.setString(2, board.getBoardContent());
			ptmt.setString(3, board.getBoardWriter());

			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
