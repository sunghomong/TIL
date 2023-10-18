package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스에서 전체 데이터를 읽어온 후
		// 화면에 보내주는 역할
		
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductVO> list = dao.selectProductAll();
		
		request.setAttribute("productList", list);
		
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);
	}

}
