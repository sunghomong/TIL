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
		
		// code ���� ���ؼ� ������ �о���� => DAO
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO product = dao.selectProductByCode(code);
		
		
		// �о�� �����͸� JSP�������� �Ѱ��ֱ�
		
		request.setAttribute("product", product);
		
		
		// JSP�� �̵�
		request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);
		
	}

}
