package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.BoardDAO;

@WebServlet("/deleteBoard")
public class DeleteBoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(boardNum);
		
		request.getRequestDispatcher("boardList").forward(request, response);
	}
}
