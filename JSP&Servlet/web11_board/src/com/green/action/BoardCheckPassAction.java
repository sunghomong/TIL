package com.green.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;

public class BoardCheckPassAction implements Action {

	private BoardCheckPassAction () {}
	private static BoardCheckPassAction bcpa = new BoardCheckPassAction();
	public static BoardCheckPassAction getInstance() {
		return bcpa;
	}
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = null;
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstence();

		if(dao.checkPassword(num, pass)) { // ��ȣ Ȯ�� ����
			url = "board/checkSuccess.jsp";
		}else { // ��ȣ Ȯ�� ����
			request.setAttribute("message", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			url = "board/boardCheckPass.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
