package com.green.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.action.Action;


@WebServlet("/BS")
public class BoardServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doService(request, response);
	}

	
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// command ���� ���ؼ� � ����� �������� ����
		String command = request.getParameter("command");
		
		// command ������ �ش� ����� ������ ��ü�� ����� ���丮
		ActionFactory af = ActionFactory.getInstence();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
		
	}
}
