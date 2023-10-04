<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
	아이디 : ${member.id}<br>
	이름 : ${member.name}<br>
	이메일 : ${member.email}<br>
	가입일 : ${member.regdate}<br>
</body>
</html>