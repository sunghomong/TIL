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

		if(dao.checkPassword(num, pass)) { // 암호 확인 성공
			url = "board/checkSuccess.jsp";
		}else { // 암호 확인 실패
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
			url = "board/boardCheckPass.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
