package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.BoardVO;

public class BoardDAO {
	// DAO �̱��� ����
	private BoardDAO() {}
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstence() {
		return dao;
	}
	
// ---------------------------------------------------------------------
	// �Խù� ��� ��ȸ
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = new ArrayList<>(); 
		
		String sql = "SELECT * FROM board ORDER BY num DESC";
											// �ֽ� ���� ��ܿ� ���̵���
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setPass(rs.getString("pass"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	
// -------------------------------------------------------------------------------------------
	// �Խù� ���
	
	public void insertBoard(BoardVO board) {
		String sql ="INSERT INTO board (num,name,pass,email,title,content)"
					+ "VALUES (board_seq.nextval,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, board.getName());
			psmt.setString(2, board.getPass());
			psmt.setString(3, board.getEmail());
			psmt.setString(4, board.getTitle());
			psmt.setString(5, board.getContent());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
// -------------------------------------------------------------------------------------------
	// �Խñ� ��ȸ�� ��Ƚ�� ���� �޼���
	public void updateReadcountBYNum(int num) {
		String sql = "UPDATE board SET readcount=readcount+1 WHERE num=" + num;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}
	
// -------------------------------------------------------------------------------------------
	// �Խñ� �󼼺��⸦ ���� �޼���
	public BoardVO selectBoardByNum(int num) {
		BoardVO board = null;
		
		String sql = "SELECT * FROM board WHERE num=" + num;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				board = new BoardVO();
				
				board.setNum(rs.getInt("num"));
				board.setReadCount(rs.getInt("readcount"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setPass(rs.getString("pass"));
				board.setWritedate(rs.getTimestamp("writedate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		return board;
	}
	
// ------------------------------------------------------------------------------------------------------------
	// ��ȣ Ȯ�� �޼���
	public boolean checkPassword(int num, String pass) {
		BoardVO board = selectBoardByNum(num);
		
		if(board.getPass().equals(pass)) {
			return true; // ��ȣ ��ġ
		}else {
			return false; // ��ȣ ����ġ
		}
		
	}
	
// ------------------------------------------------------------------------------------------------------------
	// �Խñ� ���� �޼���
	public void updateBoard(BoardVO board) {
		String sql = "UPDATE board SET name=?,email=?,pass=?,title=?,content=? WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, board.getName());
			psmt.setString(2, board.getEmail());
			psmt.setString(3, board.getPass());
			psmt.setString(4, board.getTitle());
			psmt.setString(5, board.getContent());
			psmt.setInt(6, board.getNum());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
// ----------------------------------------------------------------------------------------------------
	// �Խñ� ���� �޼���
	public void deleteBoard(int num) {
		String sql = "DELETE FROM board WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, num);
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}
	
// ---------------------------------------------------------------------------------------------------
	// 전체 게시글 수 알아오는 메서드
	public int selectAllBoardNum() {
		int cntAll = 0;
		
		String sql = "SELECT COUNT(*) FROM board";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				cntAll = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return cntAll;
	}
	
	
// ---------------------------------------------------------------------------------------------------
	// 현재 페이지 정보를 통해서 게시글 목록 읽어오기 (<= 게시물 목록 조회 대체)
	public List<BoardVO> selectTargetBoard(int section, int pageNum) {
		List<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * " + 
				"    FROM(SELECT ROWNUM AS nicknum,num,name,email,pass,title,content,readCount,writedate   " + 
				"        FROM (SELECT * FROM board ORDER BY num DESC))    " + 
				"     WHERE nicknum BETWEEN (?-1)*100 + (?-1)*10 + 1 AND (?-1)*100 + (?-1)*10+10";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, section);
			psmt.setInt(2, pageNum);
			psmt.setInt(3, section);
			psmt.setInt(4, pageNum);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setPass(rs.getString("pass"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
