<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<script type="text/javascript" src= "./script/member.js"></script>
</head>
<body>
	<h2>회원 정보 수정 페이지</h2>
	<form action="memberUpdate" method="post" name="frm">
		<!-- action 생략가능 생략할시 본주소로 이동 -->
		<table>
			<tr>
				<th> 이름 </th>
				<td> <input type="text" name="name" size="20" value = "${member.name}" readonly="readonly" > </td>
			</tr>
			<tr>
				<th> 아이디 </th>
				<td> <input type="text" name="userid" size="20" value = "${member.userid}" readonly> </td>
			</tr>
			<tr>
				<th> 비밀번호 </th>
				<td> <input type="password" name="userpwd" size="20"> </td>
			</tr>
			<tr>
				<th> 비밀번호 확인 </th>
				<td> <input type="password" name="pwd_check" size="20"> </td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td> <input type="email" name="email" size="20" value = "${member.email}"> </td>
			</tr>
			<tr>
				<th> 전화번호 </th>
				<td> <input type="tel" name="phone" size="20" value = "${member.phone}"> </td>
			</tr>
			<tr>
				<th> 등급 </th>
				<td> 
					<c:choose>
						<c:when test="${member.admin == 0}">
							<input type = "radio" name = "admin" value = "0" checked> 일반 회원
							<input type = "radio" name = "admin" value = "1" > 관리자
						</c:when>
						<c:when test="${member.admin == 1}">
							<input type = "radio" name = "admin" value = "0" > 일반 회원
							<input type = "radio" name = "admin" value = "1" checked> 관리자
						</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<button type="submit" onclick="return updatecheck()">수정</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>