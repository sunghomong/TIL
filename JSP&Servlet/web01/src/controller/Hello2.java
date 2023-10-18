package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello2
 */
@WebServlet("/hh")
public class Hello2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ���� ó���� ���� ��ü : HttpServletResponse response
		
		response.setContentType("text/html; charset = UTF-8;"); // ��½� �ѱ� ���� ����
		
		PrintWriter out = response.getWriter(); // �μ��  ��ü
		
		// HTML ������ �μ��� ���ô�.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("<head>");
		out.println("<body>");
//		out.println("<h1> Hello World! </h1>");
		String str = "��ο� ����";
		out.println("<h1>" + str + "</h1>");
		out.println("</body></html>");
		
	}

}
