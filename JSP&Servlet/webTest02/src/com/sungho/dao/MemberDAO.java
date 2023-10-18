package com.sungho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sungho.vo.MemberVO;

public class MemberDAO {

	// 싱글턴 구성
	private MemberDAO() {
	};

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getInstance() {
		return dao;
	}

	private Connection getConnection() throws Exception {
		Context initContext = new InitialContext(); // javax.naming
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle"); // javax.sql
		Connection conn = ds.getConnection();

		return conn;
	}
	
// 커피의 이름을 갖고 정보를 불러오기
   public MemberVO getCoffe(String coffeName,String size) {
	   
	   MemberVO mVo = null;
	   
	   String sql = "SELECT * FROM coffeMenu WHERE coffeName=? ";
	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	   
	   try {
		   conn = getConnection();
		   
		   psmt = conn.prepareStatement(sql);
		   
		   psmt.setString(1,coffeName);
		   
		   rs = psmt.executeQuery();
		   
		   if(rs.next()) {
			   mVo = new MemberVO();
			   
			   mVo.setCoffeName(rs.getString("coffeName"));
			   mVo.setSize(size);
			   
			   System.out.println("사이즈 값: "+rs.getInt(size));
			   mVo.setAmount(rs.getInt(size));
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   try {
			   if(rs!=null)rs.close();
			   if(psmt!=null)psmt.close();
			   if(conn!=null)conn.close();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
	   System.out.println("사이즈 : "+size);
	   return mVo;
   }
	
	
}
