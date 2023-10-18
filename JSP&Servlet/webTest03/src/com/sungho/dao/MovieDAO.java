package com.sungho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sungho.vo.MovieVO;

public class MovieDAO {
	private MovieDAO() {
	}

	private static MovieDAO dao = new MovieDAO();

	public static MovieDAO getInstance() {
		return dao;
	}

	// 연결 객체를 가져오는 메서드
	private Connection getConnection() throws Exception {
		Context initContext = new InitialContext(); // javax.naming
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle"); // javax.sql
		Connection conn = ds.getConnection();

		return conn;
	}

	// 1. select 쿼리를 수행후 종료하기 위한 메서드
	private void close(Connection conn, Statement stmt, ResultSet rs) {
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

	// 2. insert, update, delete 쿼리를 수행후 종료하기 위한 메서드
	private void close(Connection conn, Statement stmt) {
		try {

			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MovieVO> selectMovieAll() {
		List<MovieVO> list = new ArrayList<>();

		String sql = "SELECT * FROM movieTbl";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MovieVO mVo = new MovieVO();

				mVo.setMovieTitle(rs.getString("movieTitle"));
				mVo.setMovieDirector(rs.getString("movieDirector"));
				mVo.setMainActor(rs.getString("mainActor"));
				mVo.setStealCutUrl(rs.getString("stealCutUrl"));
				mVo.setAsterion(Integer.parseInt(rs.getString("asterion")));
				mVo.setSummary(rs.getString("summary"));

				list.add(mVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return list;
	}

	public void insertmovie(MovieVO mVo) {
		String sql = "INSERT INTO movieTbl VALUES(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mVo.getMovieTitle());
			psmt.setString(2, mVo.getMovieDirector());
			psmt.setString(3, mVo.getMainActor());
			psmt.setString(4, mVo.getStealCutUrl());
			psmt.setInt(5, mVo.getAsterion());
			psmt.setString(6, mVo.getSummary());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt);
		}
	}

}
