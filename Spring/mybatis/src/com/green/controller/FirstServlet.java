package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.dao.MemberDaoForMybatis;
import com.green.vo.MemberVO;


@WebServlet("/FS")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "member/lists.jsp";
	
		// 데이터베이스에 접속해서 전체 회원 정보 가져오기  =>
//	    1. 마이바티스 사용 안하는 오리지널 방식
//		MemberDAO dao = MemberDAO.getInstance();
//		List<MemberVO> lists = dao.selectAll();
		
//      2. 마이바티스를 사용한 방식
		MemberDaoForMybatis dao = MemberDaoForMybatis.getInstance();
		List<MemberVO> lists = dao.selectAll();
		
		request.setAttribute("lists", lists);
		
		request.getRequestDispatcher(url).forward(request, response);
	
	}

}
