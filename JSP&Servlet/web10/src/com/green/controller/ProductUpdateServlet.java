package com.green.controller;

import java.io.File;
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


@WebServlet("/productUpdate")
public class ProductUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		// �ڵ� ���� ���ؼ� �� ������ �о����
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO pVo = dao.selectProductByCode(code);
		
		// �󼼵����͸� ���������� �Ѱ��ֱ�
		request.setAttribute("product", pVo);
		
		// �� ������ �̵�
		request.getRequestDispatcher("product/productUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String saveFolder = "Z:\\upload";
		int fileSize = 100*1024*1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multiReq = new MultipartRequest(request, saveFolder, fileSize,encType,new DefaultFileRenamePolicy());
			
			int code = Integer.parseInt(request.getParameter("code"));
			String name = multiReq.getParameter("name");
			int price = Integer.parseInt(multiReq.getParameter("price"));
			String pictureUrl = multiReq.getFilesystemName("pictureUrl");
			String description = multiReq.getParameter("description");
			
			if(pictureUrl == null) { // ���� ���Ұ̴ϴ�.
				pictureUrl = multiReq.getParameter("originPic");
			} else { // ���� �� �̴ϴ�. => ���� �̹��� ����
				File file = new File("Z:\\upload\\" + multiReq.getParameter("orginPic"));
				file.delete();
			}
			
			// �о�� �����͸� �� �����Ѵ�
			ProductVO product = new ProductVO();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			product.setPictureUrl(pictureUrl);
			product.setDescription(description);
			
			// ����� �ڹٺ��� �����ͺ��̽� ����
			ProductDAO dao = ProductDAO.getInstance();
			dao.updateProduct(product);
					
			// �̵�
			// -> ��Ϻ���
			response.sendRedirect("productList");
			
			// -> �� ����
//			response.sendRedirect("productDetail.jsp?code= " + code);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
