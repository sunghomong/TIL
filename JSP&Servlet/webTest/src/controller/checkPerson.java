package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkPerson
 */
@WebServlet("/check_cr")
public class checkPerson extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8;");
		PrintWriter out = response.getWriter();
//		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("check_name");
		float temp = Float.parseFloat(request.getParameter("check_temp"));	
		
		if (temp >= 37.5) {
			int ran = (int)(Math.random()*(100 - 1)+1) + 1;
			if(ran % 2 == 1) {
				out.println("<h2>" + name + "님의 코로나 검사 결과는" + "음성입니다.</h2>");
			}else {
				out.println("<h2>" + name + "님의 코로나 검사 결과는" + "양성입니다.</h2>");
			}
		}else {
			out.println("<h2>" + name + "님의 코로나 검사 결과는" + "음성입니다.</h2>");
		}
		
		
		
		
//		out.println("<h2>" + name + "님의 코로나 결과는" +);
		
	}

}
