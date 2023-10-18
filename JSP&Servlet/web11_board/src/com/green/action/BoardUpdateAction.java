package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;


public class BoardUpdateAction implements Action {
	
	private BoardUpdateAction() {}
	private static BoardUpdateAction bua = new BoardUpdateAction();
	public static BoardUpdateAction getInstance() {
		return bua;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO board = new BoardVO();
		
		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setName(request.getParameter("name"));
		board.setEmail(request.getParameter("email"));
		board.setPass(request.getParameter("content"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		BoardDAO dao = BoardDAO.getInstence();
		dao.updateBoard(board);
		
		// 돌아가기
		// -- 목록
//		response.sendRedirect("BS?command=board_list");
		// -- 상세보기 + num
		response.sendRedirect("BS?command=board_view&num="+request.getParameter("num"));
		
	}

}
