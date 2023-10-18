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

import com.green.vo.ProductVO;

public class ProductDAO {
	
	// 싱글턴 패턴
	private ProductDAO() {}
	private static ProductDAO dao = new ProductDAO();
	public static ProductDAO getInstance() {
		return dao;
	}
	
	// ------------------------------------------------------------
	// 연결 객체를 가져오는 메서드
	private Connection getConnection() throws Exception{
	      Context initContext = new InitialContext(); //javax.naming
	      Context envContext  = (Context)initContext.lookup("java:/comp/env");
	      DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); //javax.sql
	      Connection conn = ds.getConnection();
	      
	      return conn;
	}
	// 연결 해제를 위한 메서드
	// 1. select 쿼리를 수행후 종료하기 위한 메서드
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. insert, update, delete 쿼리를 수행후 종료하기 위한 메서드
	private void close(Connection conn, Statement stmt) {
		try {
			
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// --------------------------------------------------------------------------------------------------
	// 전체 데이터 읽어오는 메서드
	public List<ProductVO> selectProductAll() {
		List<ProductVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM productTbl ORDER BY code DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureUrl(rs.getString("pictureUrl"));
				pVo.setDescription(rs.getString("description"));
				
				list.add(pVo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,rs);
		}
		
		return list;
	}
// -----------------------------------------------------------------------------
	// 상품 등록
	public void insertProduct(ProductVO pVo) {
		String sql = "INSERT INTO productTbl VALUES(product_seq.nextval,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pVo.getName());
			psmt.setInt(2,pVo.getPrice());
			psmt.setString(3,pVo.getPictureUrl());
			psmt.setString(4, pVo.getDescription());
			
			psmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt);
		}
	}
	
// -------------------------------------------------------------------------------------------
	// 코드 번호를 통해서 상품의 상제 정보를 알아오기 위한 메서드
	public ProductVO selectProductByCode(int code) {
		ProductVO pVo = null;
		
		String sql = "SELECT * FROM productTbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, code);
			
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				pVo = new ProductVO();
				
				pVo.setCode(code);
				
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureUrl(rs.getString("pictureUrl"));
				pVo.setDescription(rs.getString("description"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		
		return pVo;
	}
	
	
// -------------------------------------------------------------------------------------------
	// 상품을 삭제하기 위한 메서드
	public void deleteProductByCode(int code) {
		
		String sql = "DELETE FROM productTbl WHERE code= " + code;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt);
		}
	}
	
	
// -------------------------------------------------------------------------
	// 상품정보를 수정하기 위한 메서드
	public void updateProduct(ProductVO pVo) {
		String sql = "UPDATE productTbl SET name=?,price=?,pictureUrl=?,description=? WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pVo.getName());
			psmt.setString(3, pVo.getPictureUrl());
			psmt.setString(4, pVo.getDescription());
			psmt.setInt(2, pVo.getPrice());
			psmt.setInt(5, pVo.getCode());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, psmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
