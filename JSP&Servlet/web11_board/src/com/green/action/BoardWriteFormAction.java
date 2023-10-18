package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action {
	
	private BoardWriteFormAction() {}
	private static BoardWriteFormAction bwfa = new BoardWriteFormAction();
	public static BoardWriteFormAction getInstence() {
		return bwfa;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("board/boardWrite.jsp").forward(request, response);
	}

}
