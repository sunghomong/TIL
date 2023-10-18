package com.green.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager { // DB ���� �� ���� ����� ����ϴ� Ŭ����

	// DB ������ ���� �޼���
	public static Connection getConnection() { // DBManager.getConnection();
		Connection conn = null;

		try {
			Context initContext = new InitialContext(); // javax.naming
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle"); // javax.sql
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	// DB ���� ������ ���� �޼���    DBManager.close(?,?,?);
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DBManager.close(?,?);
	public static void close(Connection conn, Statement stmt) {
		try {
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
