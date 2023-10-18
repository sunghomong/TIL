<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uId = "HR";
	String uPwd = "1234";
	
	String returnUrl = "";
	
	Connection con = null;
	PreparedStatement psmt = null;
	
	String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
	
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	int admin = Integer.parseInt(request.getParameter("admin"));
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, uId, uPwd);
		
		psmt = con.prepareStatement(sql);
		
		psmt.setString(1, name);
		psmt.setString(2, userid);
		psmt.setString(3, userpwd);
		psmt.setString(4, email);
		psmt.setString(5, phone);
		psmt.setInt(6, admin);
		
		int num = psmt.executeUpdate();
		
		if(num==1){
			returnUrl="ex04_success.jsp";
		}else{
			returnUrl="ex04_fail.jsp";
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(psmt!=null)psmt.close();
			if(con!=null)con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	response.sendRedirect(returnUrl);
	
	
%>