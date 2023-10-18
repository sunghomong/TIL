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
		
		// 코드 값을 통해서 상세 데이터 읽어오기
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO pVo = dao.selectProductByCode(code);
		
		// 상세데이터를 폼페이지에 넘겨주기
		request.setAttribute("product", pVo);
		
		// 폼 페이지 이동
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
			
			if(pictureUrl == null) { // 수정 안할겁니다.
				pictureUrl = multiReq.getParameter("originPic");
			} else { // 수정 할 겁니다. => 기존 이미지 삭제
				File file = new File("Z:\\upload\\" + multiReq.getParameter("orginPic"));
				file.delete();
			}
			
			// 읽어온 데이터를 잘 포장한다
			ProductVO product = new ProductVO();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			product.setPictureUrl(pictureUrl);
			product.setDescription(description);
			
			// 포장된 자바빈을 데이터베이스 전달
			ProductDAO dao = ProductDAO.getInstance();
			dao.updateProduct(product);
					
			// 이동
			// -> 목록보기
			response.sendRedirect("productList");
			
			// -> 상세 보기
//			response.sendRedirect("productDetail.jsp?code= " + code);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
