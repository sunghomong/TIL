<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script type="text/javascript" src= "./script/member.js"></script>
</head>
<body>
	<h2>회원 탈퇴</h2>
	<form action="memberDelete" method="post" name="frm">
		<table>
			<tr>
				<th> 아이디 </th>
				<td> <input type="text" name="userid" size="20" value = "${member.userid}"> </td>
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
				<td colspan = "2">
					<button type="submit" onclick="return deletecheck()">삭제</button>
					<button type="reset">취소</button> 
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>