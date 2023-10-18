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
		
		System.out.println("국어 점수 : " + ksco);
		System.out.println("영어 점수 : " + esco);
		System.out.println("수학 점수 : " + msco);
		System.out.println("총점 : " + totalSco);
		System.out.println("평균 점수 : " + avgSco);
	}

}
