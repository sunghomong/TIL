package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vo.Member;

@WebServlet("/AjaxTest02")
public class AjaxTest02Servlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Member member = new Member();
		member.setUserId("blue");
		member.setUserName("박블루");
		member.setUserPassword("4321");

		Gson gson = new Gson();
		String memberJson = gson.toJson(member);

		// -------------------------------------------------------
		// 클라이언트에게 비동기로 문자열 데이터를 보내는 방식
		response.setContentType("text/html; charset=UTF-8;");
								// MIME 타입
		PrintWriter out = response.getWriter();

		out.print(memberJson);
		
		

	}

}
