package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class gugudanCont extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		for (int i = 1; i<= 9; i++) {
			System.out.println(dan + "X" + i + "=" + (dan * i));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8;");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		out.println("<p>" + dan + "´Ü Ãâ·Â" + "</p>");
		for (int i = 1; i<= 9; i++) {
			out.println("<p>" + dan + "X" + i + "=" + (dan * i) + "</p>");
		}
	}

}
