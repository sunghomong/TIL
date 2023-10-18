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
		
		// 응답 처리를 위한 객체 : HttpServletResponse response
		
		response.setContentType("text/html; charset = UTF-8;"); // 출력시 한글 깨짐 방지
		
		PrintWriter out = response.getWriter(); // 인쇄기  객체
		
		// HTML 문서를 인쇄해 봅시다.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("<head>");
		out.println("<body>");
//		out.println("<h1> Hello World! </h1>");
		String str = "헬로우 월드";
		out.println("<h1>" + str + "</h1>");
		out.println("</body></html>");
		
	}

}
