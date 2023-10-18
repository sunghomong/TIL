<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${(param.userId eq 'green') && (param.userPwd eq '1234')}">
			<c:redirect url="login_success.jsp" />
		</c:when>
		<c:otherwise>
			<c:redirect url="login_false.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>