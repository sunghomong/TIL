<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 파일 업로드 폼 페이지 </h2>
	<!-- 파일 업로드 할려고 할시에 get 사용 불가 -->
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		작성자 : <input type="text" name="name"> <br>
		제   목 : <input type="text" name="title"> <br>
		파   일 : <input type="file" name="uploadFile"> <br>
		<button type="submit">전송</button>
	</form>
</body>
</html>