package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �׳� ���������� �������ִ� ����
		
		String url = "member/login.jsp";
		
		// �α����� ����ڰ� �ִٸ�
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			url = "main.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
//		System.out.println("����Ʈ ȣ��");
		
		request.setCharacterEncoding("UTF-8");
		String url = "member/login.jsp";
		
		// ��(Ŭ���̾�Ʈ)���� ���� ������ id, password
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		
		// id,password�� DAO�� ���� �޼��带 ���ؼ� ���� üũ : 1, 0, -1
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid, userpwd);
		
		if(result == 1) { // �α��� ����
			// ȸ�� ������ ���ǿ� ����
			HttpSession session = request.getSession();
			MemberVO mVo = dao.getMember(userid);
			
			session.setAttribute("loginUser", mVo);
			
			url = "main.jsp";
		}else if(result == 0) { // �α��� ���� : ��й�ȣ�� Ʋ�����
			request.setAttribute("message","��й�ȣ�� ���� �ʽ��ϴ�.");
		}else if(result == -1) { // �α��� ���� : ���̵� ���� ���
			request.setAttribute("message","�������� �ʴ� ȸ���Դϴ�.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
