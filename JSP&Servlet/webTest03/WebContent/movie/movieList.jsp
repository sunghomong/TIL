<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: #333;
	color: white;
	margin-top: 100px;
}

#wrap {
	background-color: #666;
	padding: 50px;
	width: 100%;
	margin: auto;
	padding-bottom: 100px;
}

h1 {
	margin-bottom: 70px;
	text-shadow: 1px 3px 3px black;
}

.list {
	border: 1px solid black;
}

th, td {
	border: 1px solid black;
}

a {
	text-decoration: none;
	color: white;
	cursor: pointer;
}

a:hover {
	color: #999;
}
img {
	
}
</style>
</head>
<body>
	<div id="wrap" align="center">
		<h1>영화 리스트 - 판매자 페이지</h1>
		<table class="list">
			<tr>
				<th>번 호</th>
				<th>영화 제목</th>
				<th>영화 감독</th>
				<th>주연 배우</th>
				<th>스틸컷</th>
				<th>별점</th>
				<th>줄거리</th>
			</tr>
			<c:forEach var="movie" items="${movie}" varStatus="s">
				<tr>
					<td>${s.count}</td>
					<td>${movie.movieTitle}</td>
					<td>${movie.movieDirector}</td>
					<td>${movie.mainActor}</td>
					<td>
					<c:choose>
						<c:when test="${empty movie.stealCutUrl}">
							<img alt="영화 이미지" src="/upload/noimage.jpg" style="width:100px; height:100px;">
						</c:when>
						<c:otherwise>
							<img alt="영화 이미지" src="/upload/${movie.stealCutUrl}" style="width:100px; height:100px;">
						</c:otherwise>
					</c:choose>
					</td>
					<td>${movie.asterion}</td>
					<td>${movie.summary}</td>
				</tr>
				<!-- <%-- <c:if test="${s.count>= 10}">
					<a></a>
				</c:if> --%> -->
			</c:forEach>
			<tr>
				<td colspan="5" style="border: white; text-align: right;"><a
					href="movieWrite"> 영화 등록 </a></td>
			</tr>

		</table>
	</div>
</body>
</html>