<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 조회</title>
</head>
<body>
<%!
	// 데이터베이스에 접속하기 위한 5가지 정보
	String sql = "SELECT * FROM member";  // DBMS에 보낼 쿼리문
%>

<table border="1">
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>권한(1:관리자, 0:일반회원)</th>
	</tr>
	<%
		// 데이터베이스 연결용 객체 선언문
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try{
			// 1 단계 : 드라이버 로드
			// Class.forName("oracle.jdbc.driver.OracleDriver");
		
			// 2 단계 : 데이터베이스 연결 (연결 객체 준비)
			// conn = DriverManager.getConnection(url,uId,uPwd);
				
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		
			// 3 단계 : 쿼리문을 전달해줄 객체 생성
			stmt = conn.createStatement();
		
			// 4 단계 :  쿼리문을 전달
			rs = stmt.executeQuery(sql);  // 데이터를 읽어오기 위한 쿼리를 보내기 위한 메서드 (SELECT)
		//	stmt.executeUpdate(sql); // 데이터를 보내기 위한 쿼리를 보내기 위한 메서드 (INSERT, UPDATE, DELETE)
		
			if(rs!=null){
				System.out.println("데이터 가져오기 성공!");
			}
		
			// 5 단계 :  데이터를 꺼내서 출력하기
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString("name") +"</td>");
				out.println("<td>"+rs.getString("userid") +"</td>");
				out.println("<td>"+rs.getString("userpwd") +"</td>");
				out.println("<td>"+rs.getString("email") +"</td>");
				out.println("<td>"+rs.getString("name") +"</td>");
				out.println("<td>"+rs.getInt("admin") +"</td>");
				out.println("</tr>");
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{	
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){stmt.close();}
				if(conn!=null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	
	%>
	
</table>
</body>
</html>