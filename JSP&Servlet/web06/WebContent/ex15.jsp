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
	<h3> 경로를 저장하기 </h3>
	<c:url var = "pic" value="images/bride-8182890_1280.jpg" scope="request"/>
	<div>${pic}</div>
	<hr>
	<img alt="결혼" src="${pic}" width="150" height="150">
	
</body>
</html>