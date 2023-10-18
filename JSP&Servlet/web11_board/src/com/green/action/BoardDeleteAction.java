package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;

public class BoardDeleteAction implements Action {
	
	private BoardDeleteAction() {}
	private static BoardDeleteAction bda = new BoardDeleteAction();
	public static BoardDeleteAction getInstance() {
		return bda;
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstence();
		dao.deleteBoard(num);
		
		request.getRequestDispatcher("board/boardDelete.jsp").forward(request, response);
		
	}

}
