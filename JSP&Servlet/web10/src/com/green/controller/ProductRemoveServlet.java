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
		
		// �ڵ� ������ �����ͺ��̽��� ���� ��û
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO product = dao.selectProductByCode(code); // ���ϸ��� �о���� ���ؼ�
		dao.deleteProductByCode(code);
		
		// [�߰�] ���� ����
//		File file = new File("��ο� ���ϸ�");
		File file = new File("Z:\\upload\\" + product.getPictureUrl());
		file.delete();
		
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('�����Ǿ����ϴ�.');");
		out.println("location.href='productList';");
		out.println("</script>");
	}

}
