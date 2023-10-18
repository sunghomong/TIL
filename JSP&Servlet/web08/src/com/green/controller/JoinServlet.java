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
		// ���������� �̵�
		
		request.getRequestDispatcher("member/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// ������ ���� ������ �о����
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		
		// �ڹٺ����� ����
		MemberVO member = new MemberVO();
		member.setName(name);
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);
		
		// �����ͺ��̽��� ����
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(member);
		
		if(result == 1) {
			request.setAttribute("userid", userid);
			request.setAttribute("message", "ȸ�� ���Կ� �����߽��ϴ�.");
		}else {
			request.setAttribute("message", "ȸ�� ���Կ� �����߽��ϴ�.");
		}
		
		
		
		// main���� ���ư���
//		response.sendRedirect("login");
		
		request.getRequestDispatcher("member/login.jsp").forward(request, response);
	}

}
