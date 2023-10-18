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

@WebServlet("/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userid");
				
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO mVo = dao.getMember(userId);
				
		request.setAttribute("member", mVo);
				
		request.getRequestDispatcher("member/memberDelete.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		
		// �ڹٺ����� ����
		MemberVO member = new MemberVO();
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		
		// �����ͺ��̽��� ����
		MemberDAO dao = MemberDAO.getInstance();
		int result1 = dao.userCheck(userid, userpwd);
		
		if(result1 == 1) { // ���̵�,��й�ȣ ��� ��ġ
			
			int result = dao.deleteMember(member);
			if(result == 1) {
				request.setAttribute("message", "ȸ�� Ż���ϼ̽��ϴ�.");
			}else {
				request.setAttribute("message", "ȸ�� Ż�� �����ϼ̽��ϴ�.");
			}
			
			// ���� �ʱ�ȭ
			request.getSession().invalidate();
		}else if(result1 == 0) { // ��й�ȣ�� Ʋ�����
			request.setAttribute("message","��й�ȣ�� ���� �ʽ��ϴ�.");
		}else if(result1 == -1) { // ���̵� ���� ���
			request.setAttribute("message","�������� �ʴ� ȸ���Դϴ�.");
		}
		request.getRequestDispatcher("member/login.jsp").forward(request, response);
	}
}
