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
		// �����ͺ��̽����� ��ü �����͸� �о�� ��
		// ȭ�鿡 �����ִ� ����
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int admin = dao.getAdmin(userid);
		
		List<MemberVO> list = dao.selectMemberAll();

		if (admin == 1) {
			url = "member/memberList.jsp";
			request.setAttribute("memberList",list);
		}else if (admin == 0) {
			url = "main.jsp";
			request.setAttribute("message","����� �Ϲ� ȸ���̶� �� �� �����ϴ�.");
		}else {
			url = "main.jsp";
			System.out.println("admin �� : " + admin);
			request.setAttribute("message","�������� �ʴ� �����Դϴ�.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
