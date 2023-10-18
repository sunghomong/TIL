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



/**
 * Servlet implementation class MemberCheck
 */
@WebServlet("/memberCheck")
public class MemberCheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "";
		// 데이터베이스에서 전체 데이터를 읽어온 후
		// 화면에 보내주는 역할
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int admin = dao.getAdmin(userid);
		
		List<MemberVO> list = dao.selectMemberAll();

		if (admin == 1) {
			url = "member/memberList.jsp";
			request.setAttribute("memberList",list);
		}else if (admin == 0) {
			url = "main.jsp";
			request.setAttribute("message","당신은 일반 회원이라 볼 수 없습니다.");
		}else {
			url = "main.jsp";
			System.out.println("admin 값 : " + admin);
			request.setAttribute("message","존재하지 않는 계정입니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
