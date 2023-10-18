<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link type="text/css" rel="stylesheet" href="./style/product.css">
</head>
<body>
<div id="wrap" align="center">
	<h1> 상품 등록 페이지 - 판매자 페이지 </h1>
	<form action="productWrite" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th> 상품명 </th>
				<td> <input type="text" name="name" size="80"> </td>
			</tr>
			<tr>
				<th> 가격 </th>
				<td> <input type="number" name="price">원 </td>
			</tr>
			<tr>
				<th> 이미지 </th>
				<td> <input type="file" name="pictureUrl"> </td>
			</tr>
			<tr>
				<th> 설   명 </th>
				<td> <textarea rows="10" cols="80" name="description"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
					<button type="reset">다시 작성</button>
					<button type="button" onclick="location.href='productList'">목록 보기</button>
				</td>
			</tr>
			
			
		</table>
	</form>
</div>
</body>
</html>