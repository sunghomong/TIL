package com.green.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDaoForMybatis;


@WebServlet("/SS")
public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "member/lists.jsp";
		
		// 해시맵을 이용해서 데이터 읽어오기
		MemberDaoForMybatis dao = MemberDaoForMybatis.getInstance();
		List<HashMap<String,String>> lists = dao.selectAllToMap();
		
		request.setAttribute("lists", lists);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
