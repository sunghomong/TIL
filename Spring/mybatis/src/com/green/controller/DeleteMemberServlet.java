package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDaoForMybatis;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/DMS")
public class DeleteMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/deleteMemberForm.jsp").forward(request, response);
										// 삭제 하고 싶은 이메일 정보 받아오기
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 읽어온 이메일로 데이터 삭제하기
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		
		MemberDaoForMybatis dao = MemberDaoForMybatis.getInstance();
		dao.deleteMember(email);
		
		response.sendRedirect("http://localhost:8085/mybatis/FS");
	}

}
