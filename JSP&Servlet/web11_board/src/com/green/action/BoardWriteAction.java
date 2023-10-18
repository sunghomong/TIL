package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

public class BoardWriteAction implements Action {

	private BoardWriteAction() {}
	private static BoardWriteAction bwa = new BoardWriteAction();
	public static BoardWriteAction getInstance() {
		return bwa;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼으로 부터 가져온 데이터를 DB에 등록하기 위한 기능
		
		BoardVO board = new BoardVO();
		
		board.setName(request.getParameter("name"));
		board.setPass(request.getParameter("pass"));
		board.setEmail(request.getParameter("email"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));

		BoardDAO dao = BoardDAO.getInstence();
		dao.insertBoard(board);
		
		response.sendRedirect("BS?command=board_list");
	}

}
