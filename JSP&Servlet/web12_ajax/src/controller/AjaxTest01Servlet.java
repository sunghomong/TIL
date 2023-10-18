package controller;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import vo.Member;


@WebServlet("/AjaxTest01")
public class AjaxTest01Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		System.out.println("얻어온 값 : " + userId);
		
		
		// -------------------------------------------------------
		// 클라이언트에게 비동기로 문자열 데이터를 보내는 방식
		response.setContentType("text/html; charset=UTF-8;");
		
		PrintWriter out = response.getWriter();
		
		out.print("쉬는 시간.");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userInfo = request.getParameter("userInfo");
		
		System.out.println("얻어온 값 : " + userInfo);
		
		
		// 옛날 방식
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(userInfo);
		
		String userId = data.getAsJsonObject().get("userId").getAsString();
		String userName = data.getAsJsonObject().get("userName").getAsString();
		String userPassword = data.getAsJsonObject().get("userPassword").getAsString(); 
		
		System.out.println("[구]얻어온 아이디 : " + userId);
		System.out.println("[구]얻어온 이름 : " + userName);
		System.out.println("[구]얻어온 비밀번호 : " + userPassword);
		
		System.out.println("----------------------------------------");
		// 신규 방식
		Gson gson = new Gson();
		Member member = gson.fromJson(userInfo, Member.class);
		
		System.out.println("[신]얻어온 아이디 : " + member.getUserId());
		System.out.println("[신]얻어온 이름 : " + member.getUserName());
		System.out.println("[신]얻어온 비밀번호 : " + member.getUserPassword());
		
	}

}
