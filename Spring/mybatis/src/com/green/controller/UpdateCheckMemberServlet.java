package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDaoForMybatis;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class UpdateCheckMemberServlet
 */
@WebServlet("/UCMS")
public class UpdateCheckMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 회원의 정보를 수정할지 이메일을 입력받기 위한 폼
		request.getRequestDispatcher("member/checkEmailForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이메일을 통해서 회원 정보를 조회한 후
		// 업데이트 폼으로 연결
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		
		MemberDaoForMybatis dao = MemberDaoForMybatis.getInstance();
		MemberVO member = dao.selectByEmail(email);
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("member/updateForm.jsp").forward(request, response);
	}

}
