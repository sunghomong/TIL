<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="./script/member.js"></script>
<!-- http://localhost:8085/web08/ = > ./ -->
<style type="text/css">
	
</style>
</head>

<body>
	<div>
		<h2>로그인 페이지</h2>
		<form action="login" method="post" name="frm">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid" value = "${userid}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="userpwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" onclick="return loginCheck()">로그인</button>
						<button type="reset">다시작성</button>
						<button type="button" onclick="location.href='join'">회원 가입</button>
						
					</td>
				</tr>
				<tr>
					<td colspan="2">${message}</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>