<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사</title>
</head>
<body>
	<h2>설문 조사</h2>
	<form method="POST">
		<!-- <p>
			1. 당신의 역할은? <br>
			<label> <input type="radio" name="responses[0]" value="백엔드"> 백엔드개발자 </label> 
			<label> <input type="radio" name="responses[0]" value="프론트"> 프론트개발자 </label> 
			<label> <input type="radio" name="responses[0]" value="풀스택"> 풀스택개발자</label> 
			<select name="responses[0]">
				<option value="백엔드">백엔드개발자</option>
				<option value="프론트">프론트개발자</option>
				<option value="풀스택">풀스택개발자</option>
			</select>
			
			<form:select path="responses[0]" items="${옵션목록}"/>
		</p>
		<p>
			2. 가장 많이 사용하는 개발도구는? <br>
			<label> <input type="radio" name="responses[1]" value="Eclipse"> Eclipse </label> 
			<label> <input type="radio" name="responses[1]" value="IntelliJ"> IntelliJ </label> 
			<label> <input type="radio" name="responses[1]" value="NetBeans"> NetBeans </label> 
		</p>
		<p>
			3. 하고싶은 말 <br>
			<input type="text" name="responses[2]">
		</p> -->
		
		<c:forEach var="q" items="${questions}" varStatus="s">
			<p>
				${s.index+1}. ${q.title}<br> 
				<c:if test="${q.choice}">  <%-- 선택지 있다면 --%>
					<c:forEach var="option" items="${q.option}">
						<label> 
							<input type="radio" name="responses[${s.index}]" value="${option}"> ${option}
						</label>
					</c:forEach>
				</c:if>
				<c:if test="${!q.choice}"> <%-- 선택지 없다면 --%>
					<input type="text" name="responses[${s.index}]">
				</c:if>
			</p>
		</c:forEach>
		
		<p>
			<label>
				사는 곳 : 
				<input type="text" name="respondent.location">
			</label>
		</p>
		<p>
			<label>
				나이 : 
				<input type="number" name="respondent.age">
			</label>
		</p>
		<button type="submit">전송</button>
	</form>
</body>
</html>