<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지 - 판매자 페이지</title>
<link type="text/css" rel="stylesheet" href="style/product.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 수정 페이지</h1>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td rowspan="5"><c:choose>
							<c:when test="${empty product.pictureUrl}">
								<img alt="도서 이미지" src="/upload/noimage.jpg">
							</c:when>
							<c:otherwise>
								<img alt="도서 이미지" src="/upload/${product.pictureUrl}">
							</c:otherwise>
						</c:choose>
						<input type="hidden" name="code" value="${product.code}">
					</td>
					<th>상품 명</th>
					<td><input type="text" name="name" value="${product.name}">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" name="price" value="${product.price}"></td>
				</tr>
				<tr>
					<th>상세 설명</th>
					<td> <textarea rows="10" cols="90" name="description"> ${product.description}</textarea></td>
				</tr>
				<tr>
					<th> 사진 </th>
					<td>
						<input type="file" name="pictureUrl"><br>
						(주의사항 : 이미지를 변경하고자 할 때만 선택하세요.)
						<input type="hidden" name="originPic" value="${product.pictureUrl}">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">변경</button> &nbsp;&nbsp;&nbsp;
						<button type="reset">다시 수정</button> &nbsp;&nbsp;&nbsp;
						<button type="button" onclick="location.href='productList'">목록 보기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>