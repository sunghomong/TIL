package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDaoForMybatis;
import com.green.vo.MemberVO;


@WebServlet("/UMS")
public class UpdateMemberServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력된 데이터를 DB에 반영
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		MemberVO member = new MemberVO(email,name,password);
		
		MemberDaoForMybatis dao = MemberDaoForMybatis.getInstance();
		dao.updateMember(member);
		
		response.sendRedirect("http://localhost:8085/mybatis/FS");
	}

}
