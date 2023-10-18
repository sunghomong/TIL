<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link rel="stylesheet" type="text/css" href="style/board.css">
</head>
<body>
	<div id = "wrap">
		<h1> 게시물 등록 </h1>
		<form action="BS" method="post">
		<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th> 작성자 </th>
					<td> <input type="text" name="name" required>* 필수</td>
				</tr>
				<tr>
					<th> 비밀번호 </th>
					<td> <input type="password" name="pass" required="required">* 필수(수정,삭제시 필요)</td>
				</tr>
				<tr>
					<th> 이메일 </th>
					<td> <input type="email" name="email"> </td>
				</tr>
				<tr>
					<th> 글 제목 </th>
					<td> <input type="text" name="title" required="required"> * 필수</td>
				</tr>
				<tr>
					<th> 본문 </th>
					<td> <textarea rows="15" cols="70" name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">글 등록</button>
						<button type="reset">다시 작성</button>
						<button type="button" onclick="location.href='BS?command=board_list'">목록 보기</button>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>