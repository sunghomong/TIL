package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;


@WebServlet("/join")
public class JoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼페이지로 이동
		
		request.getRequestDispatcher("member/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 폼으로 부터 데이터 읽어오기
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		
		// 자바빈으로 포장
		MemberVO member = new MemberVO();
		member.setName(name);
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);
		
		// 데이터베이스에 전송
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(member);
		
		if(result == 1) {
			request.setAttribute("userid", userid);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
		}else {
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		}
		
		
		
		// main으로 돌아가기
//		response.sendRedirect("login");
		
		request.getRequestDispatcher("member/login.jsp").forward(request, response);
	}

}
