<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 페이지</title>
<!-- <link type="text/css" rel="stylesheet" href = "./style/product.css"> -->
</head>
<body>
	<div id="wrap" align="center">
		<h1> 회원 정보 페이지 </h1>
		<table class="list">
			<tr>
			
				<th>순서</th>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>번호</th>
				<th>등급</th>
			</tr> 
			<c:forEach var = "member" items = "${memberList}" varStatus="m">
				<tr>
					<td>${m.count}</td>
					<td>${member.name}</td>
					<td>${member.userid}</td>
					<td>${member.email}</td>
					<td>${member.phone}</td>
					<td>${member.admin}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>