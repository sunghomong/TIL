<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 메인 화면</title>
</head>
<body>
	<header>
		<h1>${userInfo.usergrade}&nbsp;&nbsp;${userInfo.username}&nbsp;&nbsp;${userInfo.ban}반&nbsp;&nbsp;담임&nbsp;&nbsp;${teacherName}</h1>
	</header>
	<div class="bar"></div>
	<hr>
	<div class="wrap">
		<table>
			<tr>
				<td><a href="gradeCheck?username=${userInfo.username}&usergrade=${userInfo.usergrade}">개인
						성적 조회</a></td>
				<td><a href="banGradeCheck?ban=${userInfo.ban}&usergrade=${userInfo.usergrade}">반 성적 조회</a></td>
			</tr>

		</table>
	</div>
	<hr>
	<c:if test="${gdResult != null}">
		<c:choose>
			<c:when test="${grades != null}">
				<div class="box">
					<table>
						<tr>
							<td>${grades.username} ${userInfo.usergrade} 성적 조회</td>
						</tr>
						<tr>
							<th>국어 점수 : </th>
							<td>${grades.kor_score}</td>
						</tr>
						<tr>
							<th>영어 점수 : </th>
							<td>${grades.eng_score}</td>
						</tr>
						<tr>
							<th>수학 점수 : </th>
							<td>${grades.math_score}</td>
						</tr>
						<tr>
							<th>과학 점수 : </th>
							<td>${grades.science_score}</td>
						</tr>
						<tr>
							<th>사회 점수 : </th>
							<td>${grades.social_score}</td>
						</tr>
						
					</table>
				</div>
			</c:when>
			<c:when test="${grades == null}">
				<p style="color: red;">당신의 성적을 조회할 수 없습니다.</p>
			</c:when>
		</c:choose>
	</c:if>
	<c:if test="${bdResult != null}">
		<c:choose>
			<c:when test="${gAVo != null}">
				<div class="box">
					<table>
						<tr>
							<td>${userInfo.ban} 반 성적 조회</td>
						</tr>
						<tr>
							<th>국어 평균 점수 : </th>
							<td>${gAVo.kor_avg}</td>
						</tr>
						<tr>
							<th>영어 평균 점수 : </th>
							<td>${gAVo.eng_avg}</td>
						</tr>
						<tr>
							<th>수학 평균 점수 : </th>
							<td>${gAVo.math_avg}</td>
						</tr>
						<tr>
							<th>과학 평균 점수 : </th>
							<td>${gAVo.sci_avg}</td>
						</tr>
						<tr>
							<th>사회 평균 점수 : </th>
							<td>${gAVo.sc_avg}</td>
						</tr>
						
					</table>
				</div>
			</c:when>
			<c:when test="${gAVo == null}">
				<p style="color: red;">${userInfo.ban}반 성적을 조회할 수 없습니다.</p>
			</c:when>
		</c:choose>
	</c:if>
	<footer>
		<h2>하단 내용</h2>
	</footer>
</body>
</html>