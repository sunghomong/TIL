package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scores")
public class scoreContr extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ksco = Integer.parseInt(request.getParameter("Ksco"));
		int esco = Integer.parseInt(request.getParameter("Esco"));
		int msco = Integer.parseInt(request.getParameter("Msco"));
		
		int totalSco = ksco + esco + msco;
		int avgSco = totalSco/3;
		
		System.out.println("���� ���� : " + ksco);
		System.out.println("���� ���� : " + esco);
		System.out.println("���� ���� : " + msco);
		System.out.println("���� : " + totalSco);
		System.out.println("��� ���� : " + avgSco);
	}

}
