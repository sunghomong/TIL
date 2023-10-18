package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 폼 페이지로 이동
		
		// 회원 정보를 읽어와서 수정 폼에 넘겨주는 기능
		String userId = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO mVo = dao.getMember(userId);
		
		request.setAttribute("member", mVo);
		
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 폼으로 부터 데이터 읽어오기
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		
		// 자바빈으로 포장
		MemberVO member = new MemberVO();
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);
		
		// 데이터베이스에 전송
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(member);
		
		// main으로 돌아가기
		response.sendRedirect("login");
		
		
	}

}
