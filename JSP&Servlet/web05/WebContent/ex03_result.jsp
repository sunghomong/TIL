<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
%>
<%-- 1. 자바빈 객체를 생성 --%>

<%-- 방법 1. 스크립트릿을 이용한 자바빈 생성 --%>
<%
Member member1 = new Member();
request.setAttribute("member1", member1);
%>
<%-- 방법 2. 액션태그를 이용한 자바빈 생성 --%>
<jsp:useBean id="member2"  class="domain.Member" scope="request"/>

<%-- ------------------------------------------------------------------------------ --%>
<%-- 2 데이터 저장 --%>

<%-- 방법1. 스크립트릿을 이용한 기본 저장법1,2 --%>
<%
// 저장법 1
/* String name = request.getParameter("name");
String nickName = request.getParameter("nickName");
String userId = request.getParameter("userId");
String userPw = request.getParameter("userPw");
String email = request.getParameter("email");
String phone = request.getParameter("phone");

member1.setName(name);
member1.setNickName(nickName);
member1.setUserId(userId);
member1.setUserPw(userPw);
member1.setEmail(email);
member1.setPhone(phone); */

// 저장법 2
member1.setName(request.getParameter("name"));
member1.setNickName(request.getParameter("nickName"));
member1.setUserId(request.getParameter("userId"));
member1.setUserPw(request.getParameter("userPw"));
member1.setEmail(request.getParameter("email"));
member1.setPhone(request.getParameter("phone"));
%>

<%-- 방법2. 액션태그을 이용한 기본 저장법1,2,3 --%>
<%-- 저장법 1 --%>
 
<%-- 
<jsp:setProperty name="member2"  property="name" value='<%=request.getParameter("name")%>' />
<jsp:setProperty name="member2"  property="nickName" value='<%=request.getParameter("nickName")%>' />
<jsp:setProperty name="member2"  property="userId" value='<%=request.getParameter("userId")%>' />
<jsp:setProperty name="member2"  property="userPw" value='<%=request.getParameter("userPw")%>' />
<jsp:setProperty name="member2"  property="email" value='<%=request.getParameter("email")%>' />
<jsp:setProperty name="member2"  property="phone" value='<%=request.getParameter("phone")%>' /> 
--%>

 
<%-- 저장법 2 : 읽어온 파라미터 이름과 저장하고자하는 프로퍼티 이름이 같은 경우 --%>

<%--
<jsp:setProperty name="member2"  property="name" />
<jsp:setProperty name="member2"  property="nickName"/>
<jsp:setProperty name="member2"  property="userId" />
<jsp:setProperty name="member2"  property="userPw" />
<jsp:setProperty name="member2"  property="email" />
<jsp:setProperty name="member2"  property="phone" /> 
--%>

<%-- 저장법 3 : 읽어온 파라미터 이름 목록과 저장하고자 하는 자바빈의 프로퍼티 이름이 모두 일치하는 경우 --%>
<jsp:setProperty name="member2"  property="*" />

<%-- ------------------------------------------------------------------------------ --%>
<%-- 3 데이터 출력 --%>
<h2>입력한 회원 정보 출력</h2>
<%-- 방법 1 스크립트릿을 이용한 출력 --%>
이름 : <%=member1.getName() %> <br>
닉네임 : <%=member1.getNickName() %> <br>
아이디 : <%=member1.getUserId() %> <br>
비밀번호 : <%=member1.getUserPw() %> <br>
이메일 : <%=member1.getEmail() %> <br>
전화번호 : <%=member1.getPhone() %> <br>
<hr>
<%-- 방법 2 액션태그를 이용한 출력 --%>
이름 : <jsp:getProperty name="member2" property="name" /> <br>
닉네임 : <jsp:getProperty name="member2" property="nickName" /> <br>
아이디 : <jsp:getProperty name="member2" property="userId" /> <br>
비밀번호 : <jsp:getProperty name="member2" property="userPw" /> <br>
이메일 : <jsp:getProperty name="member2" property="email" /> <br>
전화번호 : <jsp:getProperty name="member2" property="phone" /> <br>




















</body>
</html>