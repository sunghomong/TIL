<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>AjexTest01</title>
		<script src="./script/jquery-3.7.1.js"></script>
	</head>

	<body>
		<h1>Ajax 테스트 : 서버로 데이터 보내기</h1>
		<form action="#">
			아이디 : <input type="text" name="userId" id="userId">
			<button type="button" onclick="idChk()">중복 확인</button>
			<br>
			이름 : <input type="text" name="userName" id="userName"> <br>
			비밀번호 : <input type="password" name="userPassword" id="userPassword"> <br>
			<button type="button" onclick="dataTransport()">전송</button>
			<button type="button" onclick="getData()">받아오기</button>
		</form>
		<div id="msg">

		</div>
		<script>
			function idChk() {
				$.ajax({
					type: "GET", // 데이터 전송 방식 : GET/POST
					url: "AjaxTest01",	// 서버의 위치
					data: {						// 서버로 보낼 데이터
						userId: $('#userId').val() // userId 의 value 값
					},
					dataType: "text",				// 서버로 부터 받을 데이터의 종류 : text,xml,json 등
					success: function (data) { 		// 서버와 데이터 교류가 성공하면 실행할 함수
						// alert(data);
						$('#msg').append(data);
					},
					error: function () {			// 서버와 데이터 교류가 실패하면 실행할 함수
						alert('에러가 발생했습니다.');
					},
					complete: function () {		// 데이터 교류의 성공/실패 여부와 상관없이 실행할 함수
						alert('작업을 완료했습니다.');
					}
				});
			}
			function dataTransport() {
				let userInfo = {
					"userId": $('#userId').val(),
					"userName": $('#userName').val(),
					"userPassword": $('#userPassword').val()
				};
				$.ajax({
					type: "POST",
					url: "AjaxTest01",
					data: {
						"userInfo": JSON.stringify(userInfo)
					},
					success: function () {
						alert('전송에 성공했습니다.');
					}
				});
			}

			function getData(){
				$.ajax({
					type:"POST",
					url:"AjaxTest02",
					dataType:"JSON",
					success:function(data){
						// let userInfo = JSON.parse(data); // JSON데이터를 객체로 분해
						// JSON 데이터를 읽어와서 자동으로 파싱하는 기능 내장
						$('#userId').val(userInfo.userId);
						$('#userName').val(userInfo.userName);
						// $('#userPassword').val(userInfo.userPassword);
						$('#msg').append("비밀번호 : "+userInfo.userPassword);
					}
					
				});
			}
		</script>
	</body>

	</html>