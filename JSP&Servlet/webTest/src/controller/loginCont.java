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
			System.out.println("ȫ�浿�� ȯ���մϴ�.");
		}else {
			System.out.println("�׷� ���̵� ���ų� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}

}
