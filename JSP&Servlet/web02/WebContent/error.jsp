<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	에러가 발생했습니다.<br>
	<%=exception.getMessage() %>
	
	try{
		예외가 발생하면
		
	} catch(Exception e) {
		e.printstacktrace();
		e.getMessage();
	}
</body>
</html>