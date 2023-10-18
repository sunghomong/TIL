package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Member;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 이미 로그인 한 사람이라면 폼으로 가는것이 아니라 메인 페이지로 이동하는 기능
		String url = "ex05_loginForm.jsp";
		
		if(session.getAttribute("member") != null) {
			url="ex05_loginSuccess.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 내장 객체를 사용하기 위해서는 
		// 세션 객체를 생성(X) 가져와야 한다.
		HttpSession session = request.getSession();
		
		String storedId = "green";
		String storedPwd = "4321";
		// 로그인 인증처리
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		String url = "";
		
		if(storedId.equals(userId) && storedPwd.equals(userPwd)) {
//			성공 
			
//			session.setAttribute("userId", userId);
//			session.setAttribute("userName", "홍길동");
			Member member = new Member();
			member.setUserId(userId);
			member.setName("라푼젤"); 
			
			session.setAttribute("member", member); 
			
			url="ex05_loginSuccess.jsp";
		}else {
//			실패	
			url="ex05_loginFail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	
	
	
	
	
	
	
	
}
