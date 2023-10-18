<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="style/board.css">
</head>
<body>
	<div id="wrap">
		<h1>게시글 상세 보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
				<th>이메일</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writedate}" /></td>
				<th>조회수</th>
				<td>${board.readCount}</td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td colspan="3">${board.content}</td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="button"
						onclick="checkPass('BS?command=board_check_pass_form&num=${board.num}','update')">
						글 수정</button>
					<button type="button" onclick="checkPass('BS?command=board_check_pass_form&num=${board.num}','delete')">글 삭제</button>
					<button type="button"
						onclick="location.href='BS?command=board_list'">목록 보기</button>
				</td>
			</tr>
		</table>
	</div>


	<script type="text/javascript">
		function checkPass(url, info) {
			window.open(url, info, "width=500, height=500");
		}
	</script>
</body>
</html>