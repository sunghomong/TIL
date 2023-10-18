package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action {

	private BoardCheckPassFormAction() {}
	private static BoardCheckPassFormAction bcpfa = new BoardCheckPassFormAction();
	public static BoardCheckPassFormAction getInstance() {
		return bcpfa;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("board/boardCheckPass.jsp").forward(request, response);
		
	}

}
