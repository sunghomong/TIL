package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 그냥 폼페이지로 연결해주는 역할
		
		String url = "member/login.jsp";
		
		// 로그인한 사용자가 있다면
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			url = "main.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
//		System.out.println("포스트 호출");
		
		request.setCharacterEncoding("UTF-8");
		String url = "member/login.jsp";
		
		// 폼(클라이언트)으로 부터 가져온 id, password
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		
		// id,password를 DAO의 인증 메서드를 통해서 인증 체크 : 1, 0, -1
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid, userpwd);
		
		if(result == 1) { // 로그인 성공
			// 회원 정보를 세션에 저장
			HttpSession session = request.getSession();
			MemberVO mVo = dao.getMember(userid);
			
			session.setAttribute("loginUser", mVo);
			
			url = "main.jsp";
		}else if(result == 0) { // 로그인 실패 : 비밀번호가 틀린경우
			request.setAttribute("message","비밀번호가 맞지 않습니다.");
		}else if(result == -1) { // 로그인 실패 : 아이디가 없는 경우
			request.setAttribute("message","존재하지 않는 회원입니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
