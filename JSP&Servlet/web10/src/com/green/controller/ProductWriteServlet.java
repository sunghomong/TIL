package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productWrite")
public class ProductWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("product/productWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String saveFolder = "Z:\\upload";
		int fileSize = 100*1024*1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multiReq = new MultipartRequest(request, saveFolder, fileSize,encType,new DefaultFileRenamePolicy());
			ProductVO product = new ProductVO();
			product.setName(multiReq.getParameter("name"));
			product.setPrice(Integer.parseInt(multiReq.getParameter("price")));
			product.setDescription(multiReq.getParameter("description"));
			product.setPictureUrl(multiReq.getFilesystemName("pictureUrl"));
			
			ProductDAO dao = ProductDAO.getInstance();
			dao.insertProduct(product);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("productList");
	}

}
