<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form action="step3" method="POST">
		<p>
			<label>
				이메일 : <br>
				<input type="email" name="email" id="email" value="${registerRequest.email}">
			</label>
		</p>
		<p>
			<label>
				이름 : <br>
				<input type="text" name="name" id="name" value="${registerRequest.name}">
			</label>
		</p>
		<p>
			<label>
				비밀번호 : <br>
				<input type="password" name="passowrd" id="passowrd">
			</label>
		</p>
		<p>
			<label>
				비밀번호 확인 : <br>
				<input type="password" name="confirmPassword" id="confirmPassword">
			</label>
		</p>
		<button type="submit">가입 완료</button>
	</form> 
</body>
</html>