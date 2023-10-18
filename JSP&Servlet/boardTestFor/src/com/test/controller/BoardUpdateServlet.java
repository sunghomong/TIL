package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.BoardDAO;
import com.test.vo.BoardVO;

@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardByNum(boardNum);

		request.setAttribute("board", board);

		request.getRequestDispatcher("board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardVO board = new BoardVO();

		board.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		board.setBoardWriter(request.getParameter("boardWriter"));
		board.setBoardTitle(request.getParameter("boardTitle"));
		board.setBoardContent(request.getParameter("boardContent"));

		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(board);

		response.sendRedirect("boardInfo?boardNum=" + request.getParameter("boardNum"));

	}

}
