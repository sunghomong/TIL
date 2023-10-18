package com.sungho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sungho.dao.MemberDAO;
import com.sungho.vo.MemberVO;

/**
 * Servlet implementation class SelectCoffe
 */
@WebServlet("/selectCoffe")
public class SelectCoffe extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 단지 저장
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "coffeOrder.jsp";
		
		String coffeName = request.getParameter("coffeName");
		
		System.out.println("종류 : "+coffeName);
		
		String size = request.getParameter("size");
		int amount = Integer.parseInt(request.getParameter("amount"));
		//System.out.println("사이즈 : "+size);
		
//		HttpSession session = request.getSession();
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO mVo = dao.getCoffe(coffeName, size);
		
//		session.setAttribute("coffeOrder", mVo);
		
		int result = mVo.getAmount() * amount;
		
		
		
		request.setAttribute("result", result);
		request.setAttribute("coffeName", coffeName);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
