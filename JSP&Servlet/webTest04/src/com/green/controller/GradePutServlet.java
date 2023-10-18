package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

@WebServlet("/gradePut")
public class GradePutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ban = request.getParameter("ban");
		
		MemberVO mVo = null;
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberVO> hasGradeMemberList = dao.getMemberListByBan(ban);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
