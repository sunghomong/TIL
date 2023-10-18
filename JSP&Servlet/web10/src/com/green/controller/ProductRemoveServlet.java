package com.green.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;

/**
 * Servlet implementation class ProductRemoveServlet
 */
@WebServlet("/productRemove")
public class ProductRemoveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		// 코드 값으로 데이터베이스에 삭제 요청
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO product = dao.selectProductByCode(code); // 파일명을 읽어오기 위해서
		dao.deleteProductByCode(code);
		
		// [추가] 파일 삭제
//		File file = new File("경로와 파일명");
		File file = new File("Z:\\upload\\" + product.getPictureUrl());
		file.delete();
		
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("location.href='productList';");
		out.println("</script>");
	}

}
