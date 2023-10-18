<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
	<h2>회원 가입 페이지</h2>
	<p>'*' 표시 항목은 필수 입력 항목입니다.</p>
	<form action="join" method="post" name="frm">
		<table>
			<tr>
				<th> 이름 </th>
				<td> <input type="text" name="name" size="20" required="required">*</td>
			</tr> 
			<tr>
				<th> 아이디 </th>
				<td> 
					<input type="text" name="userid" size="20" required>*
					<input type="hidden" name="checkId" size="20">
					<button type="button" onclick="idCheck()">중복체크</button>
				</td>
			</tr> 
			<tr>
				<th> 비밀번호 </th>
				<td> <input type="password" name="userpwd" size="20">*</td>
			</tr>
			<tr>
				<th> 비밀번호 확인</th>
				<td> <input type="password" name="pwd_check" size="20">*</td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td> <input type="email" name="email" size="20"> </td>
			</tr>
			<tr>
				<th> 전화번호 </th>
				<td> <input type="tel" name="phone" size="20"> </td>
			</tr>
			<tr>
				<th> 등급 </th>
				<td>
					<input type="radio" name="admin" value="0" checked="checked">일반회원
					<input type="radio" name="admin" value="1">관리자
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" onclick="return joinCheck()">회원 가입</button>
					<button type="reset">다시 작성</button>
				</td>
			</tr>
			
			
			
		
		</table>
	</form>
	
</body>
</html>


