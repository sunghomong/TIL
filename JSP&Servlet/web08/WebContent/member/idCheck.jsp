<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크 페이지</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
	<h2>아이디 중복 체크 페이지</h2>
	<form name="checkIdForm">
		<input type="text" name="id" value="${userid}" id="userId" disabled>
		<c:choose>
		<c:when test="${result==1}">
			<p style="color: red">이미 사용 중인 아이디입니다.</p>
			<input type="hidden" name="chResult" value="N"/>
		</c:when>
		<c:when test="${result==0 }">
			<p style="color: red">사용가능한 아이디입니다.</p>
			<input type="hidden" name="chResult" value="Y"/>
		</c:when>
		<c:otherwise>
			<p>오류 발생</p>
			<input type="hidden" name="chResult" value="N"/>
		</c:otherwise>
		</c:choose>

		<input type="button" onclick="window.close()" value="취소"/><br>
		<input type="button" onclick="sendCheckValue()" value="사용하기"/>

	</form>
</body>
</html>