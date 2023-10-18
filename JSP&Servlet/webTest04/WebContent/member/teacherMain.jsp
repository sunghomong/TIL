<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생 메인 페이지</title>
<script src="./script/jquery-3.7.1.js"></script>
</head>
<body>
	<header>
		<h1>${userInfo.ban}반&nbsp;&nbsp;담임
			&nbsp;&nbsp;${userInfo.username}</h1>
	</header>
	<hr>
	<section>
		<a
			href="banGradeCheck?ban=${userInfo.ban}&usergrade=${userInfo.usergrade}">과목
			성적 조회</a>&nbsp;&nbsp; <a href="banMemberList?ban=${userInfo.ban}">학생
			목록</a>&nbsp;&nbsp; 
			<a href="" onclick="gradePut(e)">
			성적 등록
			<input type="hidden" value="${userInfo.ban}" id="ban">
			</a>
	</section>
	<hr>
	<script type="text/javascript">
		function gradePut(e) {
			console.log(e);
			//e.preventDefault();
			$.ajax({
				type: "GET",
				url: "gradePut",
				data: {					
					ban: $('#ban').val()
				},
				dataType: "text",			
				success: function (data) { 	
					
				},
				error: function () {	
					alert('에러가 발생했습니다.');
				},
				complete: function () {	
					alert('작업을 완료했습니다.');
				}
			});
		}
	</script>
	
	
	<c:if test="${bdResult != null}">
		<c:choose>
			<c:when test="${gAVo != null}">
				<div class="box">
					<table>
						<tr>
							<td>${userInfo.ban}반 성적 조회</td>
						</tr>
						<tr>
							<th>국어 평균 점수 :</th>
							<td>${gAVo.kor_avg}</td>
						</tr>
						<tr>
							<th>영어 평균 점수 :</th>
							<td>${gAVo.eng_avg}</td>
						</tr>
						<tr>
							<th>수학 평균 점수 :</th>
							<td>${gAVo.math_avg}</td>
						</tr>
						<tr>
							<th>과학 평균 점수 :</th>
							<td>${gAVo.sci_avg}</td>
						</tr>
						<tr>
							<th>사회 평균 점수 :</th>
							<td>${gAVo.sc_avg}</td>
						</tr>

					</table>
				</div>
			</c:when>
			<c:when test="${gAVo == null}">
				<p style="color: red;">${userInfo.ban}반성적을 조회할 수 없습니다.</p>
			</c:when>
		</c:choose>
	</c:if>
	<c:if test="${listResult != null}">
		<c:choose>
			<c:when test="${memberList != null}">
				<div class="box">
					<table>
						<tr>
							<td>${userInfo.ban}반 학생 명단 ${memberCount}명</td>
						</tr>
						<c:forEach var="list" items="${memberList}">
							<tr>
								<td>${list.num}</td>
								<td>${list.userid}</td>
								<td><a href="gradeCheck?username=${list.username}&usergrade=${userInfo.usergrade}">${list.username}</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:when test="${memberList == null}">
				<p style="color: red;">${userInfo.ban}반 학생 명단을 조회할 수 없습니다.</p>
			</c:when>
		</c:choose>
	</c:if>
	<c:if test="${gradeResult != null}">
		<c:choose>
			<c:when test="${grades != null}">
				<div class="box">
					<table>
						<tr>
							<td>${grades.username} 학생 성적 조회</td>
						</tr>
						<tr>
							<th>국어 점수 : </th>
							<td>${grades.kor_score}점</td>
						</tr>
						<tr>
							<th>영어 점수 : </th>
							<td>${grades.eng_score}점</td>
						</tr>
						<tr>
							<th>수학 점수 : </th>
							<td>${grades.math_score}점</td>
						</tr>
						<tr>
							<th>과학 점수 : </th>
							<td>${grades.science_score}점</td>
						</tr>
						<tr>
							<th>사회 점수 : </th>
							<td>${grades.social_score}점</td>
						</tr>
						<tr>
							<th>총점 : </th>
							<td>${totalGrade}점</td>
						</tr>
						<tr>
							<th>평균 : </th>
							<td>${avgGrade}점</td>
						</tr>
						
					</table>
				</div>
			</c:when>
			<c:when test="${grades == null}">
				<p style="color: red;">성적을 조회할 수 없습니다.</p>
			</c:when>
		</c:choose>
	</c:if>
	<footer>
		<h2>하단 내용</h2>
	</footer>
</body>
</html>