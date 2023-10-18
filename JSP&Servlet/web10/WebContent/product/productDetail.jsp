<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 상세 확인 페이지</title>
<link type="text/css" rel="stylesheet" href = "style/product.css">
</head>
<body>
	<div id="wrpa" align="center">
		<h1>상품 상세 페이지</h1>
		<table>
			<tr>
				<td rowspan="4">
				<!-- 
					서버에게 경로를 등록해주면 해결됨
					server.xml
					<Context docBase="Z:Z:\upload" path="\upload"/>
				 -->
					<c:choose>
						<c:when test="${empty product.pictureUrl}">
							<img alt="도서 이미지" src="/upload/noimage.jpg">
						</c:when>
						<c:otherwise>
							<img alt="도서 이미지" src="/upload/${product.pictureUrl}">
						</c:otherwise>
					</c:choose>
				</td>
				<th> 상품 명</th>
				<td> ${product.name}</td>
			</tr>
			<tr>
				<th> 가격 </th>
				<td> ${product.price}</td>
			</tr>
			<tr>
				<th> 상세 설명 </th>
				<td> ${product.description}</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="productUpdate?code=${product.code}">상품 수정</a> &nbsp;&nbsp;&nbsp;
					<a href="productRemove?code=${product.code}">상품 삭제</a> &nbsp;&nbsp;&nbsp;
					<a href="productList">목록 보기</a>
				</td>
			</tr>
			
		</table>
	</div>
</body>
</html>