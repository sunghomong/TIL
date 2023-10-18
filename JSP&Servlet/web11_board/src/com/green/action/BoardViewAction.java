package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

public class BoardViewAction implements Action {
	
	private BoardViewAction() {}
	private static BoardViewAction bva = new BoardViewAction();
	public static BoardViewAction getInstance() {
		return bva;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstence();
		dao.updateReadcountBYNum(num); // ��ȸ ����
		BoardVO board = dao.selectBoardByNum(num); // �Խñ� �о���� 
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("board/boardView.jsp").forward(request, response);

	}

}
