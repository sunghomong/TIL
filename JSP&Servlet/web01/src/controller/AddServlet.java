package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
////		int a = Integer.parseInt(request.getParameter("num1"));
//
//		String _num1 = request.getParameter("num1");
//		int num1 = Integer.parseInt(_num1);
//		int num2 = Integer.parseInt(request.getParameter("num2"));
//		int result = num1 + num2;
//		System.out.println("숫자 1 : " + num1);
//		System.out.println("숫자 2 : " + num2);
//
//		response.setContentType("text/html; charset = UTF-8;");
//
//		PrintWriter out = response.getWriter();
//
//		// HTML 문서를 인쇄해 봅시다.
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Hello</title>");
//		out.println("<head>");
//		out.println("<body>");
////		out.println("<h1> Hello World! </h1>");
//		String str = "계산 결과";
//		out.println("<h1>" + str + "</h1>");
//		out.println("<p>" + num1 + "+" + num2 + "=" + result + "</p>");
//		out.println("</body></html>");
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _num1 = request.getParameter("num1");
		int num1 = Integer.parseInt(_num1);
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = num1 + num2;
		System.out.println("숫자 1 : " + num1);
		System.out.println("숫자 2 : " + num2);

		response.setContentType("text/html; charset = UTF-8;");

		PrintWriter out = response.getWriter();

		// HTML 문서를 인쇄해 봅시다.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("<head>");
		out.println("<body>");
//		out.println("<h1> Hello World! </h1>");
		String str = "계산 결과";
		out.println("<h1>" + str + "</h1>");
		out.println("<p>" + num1 + "+" + num2 + "=" + result + "</p>");
		out.println("</body></html>");
	}
	
	
	
	
	
	
}
