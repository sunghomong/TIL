<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" href="style/board.css">
</head>
<body>
	<div class="box">
		<h1>게시물 등록</h1>
		<form action="boardWrite" method="post">
			<table>
				<tr>
					<th>작성자*</th>
					<td><input type="text" name="boardWriter" placeholder="작성자 입력란" required></td>
				</tr>
				<tr>
					<th>글 제목*</th>
					<td><input type="text" name="boardTitle" placeholder="제목 입력란" required></td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea rows="20" cols="55" name="boardContent" placeholder="내용을 입력하세요."></textarea></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<button type="submit">글 등록</button>
						<button type="reset">다시 작성</button>
						<button type="button" onclick="location.href='boardList'">목록 보기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>