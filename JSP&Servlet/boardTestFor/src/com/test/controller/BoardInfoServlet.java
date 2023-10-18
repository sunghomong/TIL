package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.BoardDAO;
import com.test.vo.BoardVO;

@WebServlet("/boardInfo")
public class BoardInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		BoardDAO dao = BoardDAO.getInstance();

		// 조회수 1 증가
		dao.plusCountByNum(boardNum);

		// 넘버를 통한 게시글 상세 정보 가져오기
		BoardVO board = dao.getBoardInfoByNum(boardNum);

		request.setAttribute("board", board);

		request.getRequestDispatcher("board/boardInfo.jsp").forward(request, response);

	}

}
