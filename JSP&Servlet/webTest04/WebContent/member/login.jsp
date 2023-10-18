<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

a {
	text-decoration: none;
	color: inherit;
}

section {
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	background-color: #333;
}

.wrap {
	font-family: "맑은 고딕", sans-serif;
	font-size: 14px;
	background-color: #fff;
	width: 300px;
	height: 400px;
	margin: 100px auto;
	box-sizing: border-box;
	padding: 10px 0 0 0;
	position: relative;
	text-align: center;
}

.wrap>.img {
	text-align: right;
	box-sizing: border-box;
	margin-right: 20px;
	margin-bottom: 10px;
}

.wrap i {
	font-size: 20px;
	text-align: right;
	cursor: pointer;
}

.wrap>.bar {
	border-bottom: 1px solid #999;;
	margin-bottom: 30px;
}

.wrap>form {
	margin-top: 30px;
	width: 220px;
	margin: auto;
}

form>p {
	font-size: 14px;
	text-align: left;
	margin-bottom: 5px;
}

input[type=text] {
	width: 220px;
	height: 40px;
	margin-bottom: 20px;
	font-size: 15px;
}

input[type=password] {
	width: 220px;
	height: 40px;
	margin-bottom: 20px;
	font-size: 15px;
}

button {
	width: 220px;
	height: 40px;
	background-color: #333;
	border: 1px solid black;
	color: #fff;
	cursor: pointer;
	margin-bottom: 20px;
}

.wrap2 {
	margin-top: 0px;
}

.wrap2>a {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<section>
		<div class="wrap">
			<div class="img">
				<i class="fa-solid fa-xmark"></i>
			</div>
			<div class="bar"></div>
			<form action="login" method="post">
				<p>아이디</p>
				<input type="text" placeholder="아이디" name="userid">
				<p>암호</p>
				<input type="password" placeholder="비밀번호" name="userpw">
				<button type="submit">로그인</button>
			</form>
			<div class="bar"></div>
			<div class="wrap2">
				<div class="message">
					${message}
				</div>
				<a href="productId">회원가입</a>
				<p style="color: #333;">copyright (c) 2022 green all rights
					reserved</p>
			</div>
		</div>
	</section>

</body>
</html>