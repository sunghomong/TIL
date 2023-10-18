package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/productDetail")
public class ProductDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		// code 값을 통해서 데이터 읽어오기 => DAO
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO product = dao.selectProductByCode(code);
		
		
		// 읽어온 데이터를 JSP페이지에 넘겨주기
		
		request.setAttribute("product", product);
		
		
		// JSP로 이동
		request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);
		
	}

}
