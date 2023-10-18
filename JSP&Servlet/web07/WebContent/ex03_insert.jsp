<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	// 데이터베이스에 접속하기 위한 5가지 정보
	String url = "jdbc:oracle:thin:@localhost:1521:XE";	// 서버주소 + 포트번호 + SID
	String uId = "HR";  	// 접속 계정
	String uPwd = "1234"; 	// 접속 비밀번호
%>
	
<%
	String name = "양길동";
	String userid = "yang";
	String userpwd = "1234";
	String email = "yang@naver.com";
	String phone = "010-1234-5678";
	int admin = 0;
	
	String sql = "INSERT INTO member "
				+" VALUES(?,?,?,?,?,?)";
	
	Connection conn = null;
//	Statement stmt = null;
	PreparedStatement psmt = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uId, uPwd);
		
		psmt = conn.prepareStatement(sql);// 미리 미완성 쿼리문을 넣는다.
		
		// 미완성 쿼리를 채워넣는 작업이 필요하다.
		psmt.setInt(6, admin);
		psmt.setString(1, name);
		psmt.setString(2, userid);
		psmt.setString(3, userpwd);
		psmt.setString(4, email);
		psmt.setString(5, phone);
		
		// 쿼리문 실행
//		psmt.executeUpdate(sql); -> 에러
		int num = psmt.executeUpdate();
		System.out.println("변경된 행의 개수 : "+num);	

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(psmt!=null)psmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
%>
</body>
</html>