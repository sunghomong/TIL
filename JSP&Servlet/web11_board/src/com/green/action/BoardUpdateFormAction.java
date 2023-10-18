package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

public class BoardUpdateFormAction implements Action {
	
	private BoardUpdateFormAction() {}
	private static BoardUpdateFormAction bufa = new BoardUpdateFormAction();
	public static BoardUpdateFormAction getInstance() {
		return bufa;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardUpdate.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstence();
		BoardVO board = dao.selectBoardByNum(num);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
