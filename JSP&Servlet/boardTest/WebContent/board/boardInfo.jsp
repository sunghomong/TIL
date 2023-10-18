<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 조회</title>
<link rel="stylesheet" href="style/board.css">
<style type="text/css">
th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="box">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th><p>글 번호</p></th>
				<td><p>${board.boardNum}</p></td>
				<th><p>조회수</p></th>
				<td><p>${board.boardCount}</p></td>
			</tr>
			<tr>
				<th><p>작성자</p></th>
				<td><p>${board.boardWriter}</p></td>
				<th><p>작성일</p></th>
				<td><p>
						<fmt:formatDate value="${board.boardRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</p></td>
			</tr>
			<tr>
				<th><p>글 제목</p></th>
				<td colspan="3"><p>${board.boardTitle}</p></td>
			</tr>
			<tr>
				<th><p>글 내용</p></th>
				<td colspan="3"><p>${board.boardContent}</p></td>
			</tr>
			<tr>
				<td colspan="4" style="border: none;">
					<button type="button"
						onclick="location.href='boardUpdate?boardNum=${board.boardNum}'">수정하기</button>
					<button type="button" onclick="location.href='boardList'">글
						목록 보기</button>
					<button type="button" id="modalOpenButton">
					삭제하기
					</button>
					<input type="hidden" name="boardNum" value="${board.boardNum}">
				</td>
			</tr>
		</table>
	</div>

	<div id="modalContainer" class="hidden">
		<div id="modalContent" style="border-radius: 5px;">
			<p style="color: red; font-size: 24px; text-align: center;">정말
				삭제하시겠습니까?</p>
			<button
				onclick="location.href='deleteBoard?boardNum=${board.boardNum}'">네</button>
			<button id="modalCloseButton">아니요</button>
		</div>
	</div>



	<script type="text/javascript">
	const modalOpenButton = document.getElementById('modalOpenButton');
	const modalCloseButton = document.getElementById('modalCloseButton');
	const modal = document.getElementById('modalContainer');

	modalOpenButton.addEventListener('click', () => {
	  modal.classList.remove('hidden');
	});

	modalCloseButton.addEventListener('click', () => {
	  modal.classList.add('hidden');
	});
	</script>
</body>
</html>