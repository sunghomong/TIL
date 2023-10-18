<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
	<h1> 영화 등록 페이지 </h1>
	<form action="movieWrite" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th> 영화 제목 </th>
				<td> <input type="text" name="movieTitle" size="80"> </td>
			</tr>
			<tr>
				<th> 영화 감독 </th>
				<td> <input type="text" name="movieDirector"> </td>
			</tr>
			<tr>
				<th> 주연 배우 </th>
				<td> <input type="text" name="mainActor"> </td>
			</tr>
			<tr>
				<th> 스틸컷 </th>
				<td> <input type="file" name="stealCutUrl"> </td>
			</tr>
			<tr>
				<th> 별점 </th>
				<td> 
					<select name="asterion" >
						<option value = "1">1
						<option value = "2">2
						<option value = "3">3
						<option value = "4">4
						<option value = "5">5
					</select>
				</td>
			</tr>
			<tr>
				<th> 줄거리 </th>
				<td> <textarea rows="10" cols="80" name="summary"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
					<button type="reset">다시 작성</button>
					<button type="button" onclick="location.href='movieList'">목록 보기</button>
				</td>
			</tr>
			
			
		</table>
	</form>
</div>
</body>
</html>