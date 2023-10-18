<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<div>
		<form action="selectCoffe" method="post" name="coffe_info">
			<select name="coffeName">
				<option value="돌체 라떼" selected>돌체 라떼</option>
				<option value="화이트 초콜릿 모카">화이트 초콜릿 모카</option>
				<option value="카페 모카">카페 모카</option>
				<option value="카페 라떼">카페 라떼</option>
				<option value="아메리카노">아메리카노</option>
				<option value="오늘의 커피">오늘의 커피</option>
				<option value="블론드 바닐라 더블샷">블론드 바닐라 더블샷</option>
			</select> <select name="size">
				<option value="coffeTallSize" selected>톨</option>
				<option value="coffeGrandeSize">그란데</option>
				<option value="coffeVentiSize">벤티</option>
			</select> <input type="text" name="amount">잔
			<button type="submit">선택</button>
		</form>
		<table>
			<tr>
				<td colspan="2">당신이 주문하신 커피는 ${coffeName}이고 가격은 ${result}원 입니다.</td>
			</tr>
		</table>
	</div>
</body>
</html>