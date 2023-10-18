<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" href="style/board.css">
</head>
<body>
	<div class="box">
		<h1>게시물 수정</h1>
		<form action="boardUpdate" method="post">

			<table>
				<tr>
					<th>작성자 *</th>
					<td><input type="text" name="boardWriter"
						value="${board.boardWriter}" required></td>
				</tr>
				<tr>
					<th>글 제목 *</th>
					<td><input type="text" name="boardTitle"
						value="${board.boardTitle}" required></td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea rows="20" cols="55" name="boardContent">${board.boardContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="boardNum"
						value="${board.boardNum}">
						<button type="submit">글 수정</button>
						<button type="reset">다시 작성</button>
						<button type="button" onclick="location.href='boardList'">목록
							보기</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>