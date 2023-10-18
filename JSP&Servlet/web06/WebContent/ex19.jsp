<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 숫자 표기 </h3>
	<fmt:formatNumber value="1234567.89"/> <br>
						<!-- 1,234,567.89 -->
	<fmt:formatNumber value="1234567.89" groupingUsed="false"/> <br>
						<!-- 1234567.89 -->
	<fmt:formatNumber value="0.35" type="percent"/> <br>
						<!-- 35% -->
	<fmt:formatNumber value="50000" type = "currency"/>
						<!-- W 50000 -->
	<fmt:formatNumber value="50000" type = "currency" currencySymbol="₡"/>
						<!-- ₡ 50000 -->
						
	<hr>
	
	<fmt:formatNumber value= "12345678.8912345" pattern="#,#00.0#"/> <br> <!-- 0,# -->
							<!-- 12,345,678.89 -->
	<fmt:formatNumber value= "12345678.8" pattern="#,#00.0#"/> <br> 
							<!-- 12,345,678.8 -->
	<fmt:formatNumber value= "12345678.8" pattern="#,#00.000"/> <br> 
							<!-- 12,345,678.800 -->
	<fmt:formatNumber value= "12.3" pattern="000,000.000"/> <br> 
							<!-- 000,012.300 -->
							
	<hr>
	<c:set var = "now" value = "<%=new java.util.Date() %>"/>
	
	<fmt:formatDate value="${now}"/> <br> <!-- 2023.08.16 type = "date" 기본값 -->
	<fmt:formatDate value="${now}" type = "time"/> <br> <!-- 오후 4:28:51 실행 시점의 시간 -->
	<fmt:formatDate value="${now}" type = "both"/> <br> <!-- 2023.08.16 오후 4:28:51 -->
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/> <br> <!-- 2023년08월16일 04시28분51초 -->
	
	<hr>
	<fmt:timeZone value="GMT">
		GMT : <fmt:formatDate value="${now}" type = "both"/> <br>
	</fmt:timeZone>
	
	<fmt:timeZone value="GMT-7">
		GMT : <fmt:formatDate value="${now}" type = "both"/> <br>
	</fmt:timeZone>
	
	<hr>
	톰캣 서버의 기본 로케일 : <%=response.getLocale() %> <br>
	
	<fmt:setLocale value="ja_JP"/>
	로케일을 일본어로 설정한 후 로케일 확인 : <%=response.getLocale() %> <br>
	통화 표기 : <fmt:formatNumber value = "10000" type="currency"/> <br> 
	날짜 표기 : <fmt:formatDate value="${now}" type="both"/> <br>
	<br>
	<fmt:setLocale value="lt_LT"/>
	로케일을 리투아니아로 설정한 후 로케일 확인 : <%=response.getLocale() %> <br>
	통화 표기 : <fmt:formatNumber value = "10000" type="currency"/> <br> 
	날짜 표기 : <fmt:formatDate value="${now}" type="both"/> <br>
	<br>
	<fmt:setLocale value="en_US"/>
	로케일을 미국 설정한 후 로케일 확인 : <%=response.getLocale() %> <br>
	통화 표기 : <fmt:formatNumber value = "10000" type="currency"/> <br> 
	날짜 표기 : <fmt:formatDate value="${now}" type="both"/> <br>
	<br>
	<fmt:setLocale value="ko_KR"/>
	로케일을 한국으로 설정한 후 로케일 확인 : <%=response.getLocale() %> <br>
	통화 표기 : <fmt:formatNumber value = "10000" type="currency"/> <br> 
	날짜 표기 : <fmt:formatDate value="${now}" type="both"/> <br>
</body>
</html>