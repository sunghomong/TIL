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


@WebServlet("/banMemberList")
public class BanMemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ban = request.getParameter("ban");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int memberCount = dao.getMemberCountByBan(ban);
		
		request.setAttribute("memberCount", memberCount);
		
		List<MemberVO> list = dao.getMemberListByBan(ban);
		
		String bdResult = null;
		String listResult = "학생 점수 리스트 출력";
		
		request.setAttribute("memberList", list);
		request.setAttribute("listResult", listResult);
		request.setAttribute("bdResult", bdResult);
		
		request.getRequestDispatcher("member/teacherMain.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
