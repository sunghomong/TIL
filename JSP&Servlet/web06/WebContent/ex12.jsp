<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movieList = { "나홀로집에", "타짜", "남자가 사랑할 때", "메트릭스", "탑건", "인셉션", "오펜하이머" };
	pageContext.setAttribute("movieList", movieList);
	%>

	<h3>반복을 통한 데이터 출력</h3>
	<c:forEach var="movieTitle" items="${movieList}">
		${movieTitle} <br>

		<!-- 		for(타입 변수 : 배열변수){
		} -->
	</c:forEach>

	<hr>
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>Title</th>
		</tr>
		<c:forEach var="movieTitle" items="${movieList}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${movieTitle}</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<ul>
		<c:forEach var="movieTitle" items="${movieList}" varStatus="status">
			<c:choose>
				<c:when test="${status.first}">
					<li style="font-weight: bold; color: red;">${movieTitle}</li>
				</c:when>
				<c:when test="${status.last}">
					<li style="background-color: blue; color: white;">${movieTitle}</li>
				</c:when>
				<c:otherwise>
					<li>${movieTitle}</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	<c:forEach var="movieTitle" items="${movieList}" varStatus="status">
		${movieTitle} <c:if test="${not status.last}">,</c:if>
	</c:forEach>

	<hr>
	<c:forEach var="cnt" begin="1" end="5" varStatus="status">
		${status.index } : ${status.count} : ${cnt}<br>
	</c:forEach>
	<br>
	<c:forEach var="cnt" begin="6" end="11" varStatus="status">
		${status.index } : ${status.count} : ${cnt}<br>
	</c:forEach>
	<br>
	<c:forEach var="cnt" begin="4" end="27" step = "3" varStatus="status">
		${status.index } : ${status.count} : ${cnt}<br>
	</c:forEach>





</body>
</html>