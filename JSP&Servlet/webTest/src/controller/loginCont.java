package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginCont extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String succId = "green";
		String succPw = "1357";
		
		if (id.equals(succId) && pw.equals(succPw)) {
			System.out.println("홍길동님 환영합니다.");
		}else {
			System.out.println("그런 아이디가 없거나 비밀번호가 틀렸습니다.");
		}
	}

}
