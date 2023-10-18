<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>과목 선택 항목</h1>
	<%
		
		String[] subList = request.getParameterValues("sub");
		if(subList[0] == null) {
			Text();
		}else{
			for(int i = 0; i <= subList.length;i++){
				
			}
		}
		
		
	%>
	
	<%! public void Text(){
		%>
		<form action="selectSubject.jsp" method = "get">
		자바 <input type = "checkbox" name="sub" value="java">
		파이썬 <input type = "checkbox" name="sub" value="python">
		C <input type = "checkbox" name="sub" value="c">
		C++ <input type = "checkbox" name="sub" value="c++">
		C# <input type = "checkbox" name="sub" value="c#">
		코틀린 <input type = "checkbox" name="sub" value="kot">
		자바스크립트 <input type = "checkbox" name="sub" value="scr">
		Go <input type = "checkbox" name="sub" value="go">
		타입스크립트 <input type = "checkbox" name="sub" value="typescr">
		러스트 <input type = "checkbox" name="sub" value="ru">
		그루비 <input type = "checkbox" name="sub" value="gro">
		R <input type = "checkbox" name="sub" value="r">
		<button type = "submit">전송</button>
		</form>
		<%!
	}
	
		
	%>
	
</body>
</html>