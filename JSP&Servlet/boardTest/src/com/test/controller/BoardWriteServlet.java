package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.BoardDAO;
import com.test.vo.BoardVO;



@WebServlet("/boardWrite")
public class BoardWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// jsp 페이지로 바로 이동
		request.getRequestDispatcher("board/boardWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardVO board = new BoardVO();

		board.setBoardWriter(request.getParameter("boardWriter"));
		board.setBoardTitle(request.getParameter("boardTitle"));
		board.setBoardContent(request.getParameter("boardContent"));

		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(board);

		response.sendRedirect("boardList");
	}

}
