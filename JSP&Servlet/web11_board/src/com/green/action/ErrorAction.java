package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorAction implements Action {

	private ErrorAction() {}
	private static ErrorAction ea = new ErrorAction();
	public static ErrorAction getInstance() {
		return ea;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("message", request.getParameter("command"));
		
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}

}
