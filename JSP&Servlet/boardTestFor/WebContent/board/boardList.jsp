<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="style/board.css">
</head>
<body>
	<div class="box">
		<h2>게시판 리스트</h2>
		<table class="boardList">
			<tr>
				<td colspan="6" style="text-align: right; line-height: 30px;"><a href="boardWrite"
					style="border: 1px solid white; padding: 10px; margin-right: 20px; font-size: 12px;">게시글
						등록</a></td>
			</tr>
			<tr style="line-height: 40px;" >
				<th>번호</th>
				<th>제목</th>
				<th>글 내용</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="list" items="${boardList}">
				<tr>
					<td>${list.boardNum}</td>
					<td><a href="boardInfo?boardNum=${list.boardNum}">
							${list.boardTitle} </a></td>
					<td>${list.boardContent}</td>
					<td>${list.boardWriter}</td>
					<td>${list.boardCount}</td>
					<td><fmt:formatDate value="${list.boardRegDate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>