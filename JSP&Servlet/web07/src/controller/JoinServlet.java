package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.Member;


@WebServlet("/joinServlet")
public class JoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 역할 : 클라이언트에게 폼 페이지를 응답하는 역할
		
		request.getRequestDispatcher("ex05_form.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼으로 부터 데이터 읽어오기
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		// 2. 데이터 포장하기(자바빈)
		Member member = new Member();
		
		member.setName(name);
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);
		
		// 3. Dao객체 insert메서드 호출
		MemberDao dao = MemberDao.getInstance();
		int num = dao.insert(member);
				
		String url = "";
		//  4. 결과에 따라서 응답되는 페이지를 결정
		if(num==1) {
			url = "ex05_success.jsp";
		}else {
			url = "ex05_fail.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
