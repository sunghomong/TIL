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
		
		
		// 자바빈으로 포장
		MemberVO member = new MemberVO();
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		
		// 데이터베이스에 전송
		MemberDAO dao = MemberDAO.getInstance();
		int result1 = dao.userCheck(userid, userpwd);
		
		if(result1 == 1) { // 아이디,비밀번호 모두 일치
			
			int result = dao.deleteMember(member);
			if(result == 1) {
				request.setAttribute("message", "회원 탈퇴하셨습니다.");
			}else {
				request.setAttribute("message", "회원 탈퇴에 실패하셨습니다.");
			}
			
			// 세션 초기화
			request.getSession().invalidate();
		}else if(result1 == 0) { // 비밀번호가 틀린경우
			request.setAttribute("message","비밀번호가 맞지 않습니다.");
		}else if(result1 == -1) { // 아이디가 없는 경우
			request.setAttribute("message","존재하지 않는 회원입니다.");
		}
		request.getRequestDispatcher("member/login.jsp").forward(request, response);
	}
}
