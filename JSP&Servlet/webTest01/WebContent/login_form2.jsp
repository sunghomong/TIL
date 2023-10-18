<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
	- 2단계 프로그램에서 로그인 성공시 아이디를 세션에 저장하는 코드를 추가하세요.
 	- 로그인 하지 않은 상태에서 로그인 성공페이지를 주소창으로 통해서 직접 들어간 경우 로그인 폼페이지로 이동하도록 코드를 작성하세요.
 	- 로그인 한 상태에서 로그인 폼페이지로 주소창으로 통해서 직접 이동한 경우 로그인 성공페이지로 이동하도록 코드를 작성하세요. 
	- 로그인 성공페이지에는 로그아웃 기능을 추가해 봅시다.
	 -->
	 
	 <h2>로그인 페이지</h2>
	
	<form action="login_test1.jsp" method = "post">
		아이디 : <input type ="text" name = "userId">
		비밀번호 : <input type ="password" name = "userPwd">
		<button type ="submit">전송</button>
	</form>
</body>
</html>