<%@page import="java.sql.DriverManager"%>
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
	String name = "강길동";
	String userid = "kang";
	String userpwd = "1234";
	String email = "kang@naver.com";
	String phone = "010-1234-5678";
	int admin = 0;
	
	String sql = " INSERT INTO member "+ 
			" VALUES('"+name+"','"+userid+"','"+userpwd+"','"+email+"','"+phone+"',"+admin+") ";
	
//	INSERT INTO member VALUES('강길동',kang,1234,kang@naver.com,010-1234-5678,0);
	
	// 0 단계 : 선언준비
	Connection conn = null;
	Statement stmt = null;
//	ResultSet rs = null;

	try{
		// 1단계 : 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2단계 : 데이터베이스 연결
		conn = DriverManager.getConnection(url,uId,uPwd);
		// 3단계 : 쿼리문 전달할 객체 생성
		stmt = conn.createStatement();
		// 4단계 : 쿼리문 실행
		int num = stmt.executeUpdate(sql); 
		System.out.println("변경된 행의 개수 : "+num);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	%>
</body>
</html>