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
		// ȸ�� ���� ���� �� �������� �̵�
		
		// ȸ�� ������ �о�ͼ� ���� ���� �Ѱ��ִ� ���
		String userId = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO mVo = dao.getMember(userId);
		
		request.setAttribute("member", mVo);
		
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// ������ ���� ������ �о����
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		
		// �ڹٺ����� ����
		MemberVO member = new MemberVO();
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);
		
		// �����ͺ��̽��� ����
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(member);
		
		// main���� ���ư���
		response.sendRedirect("login");
		
		
	}

}
