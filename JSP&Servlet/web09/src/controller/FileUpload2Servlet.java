package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUpload2Servlet
 */
@WebServlet("/fileUpload2")
public class FileUpload2Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ex02_MultiFileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();

		// 1. ������ ũ�⸦ ����
		int uploadFileSize = 5 * 1024 * 1024;
		// ���ε�� ��� ���� ũ���� �հ�

		// 2. ���� �̸� ���ڵ� ��� : UTF-8
		String encodingType = "UTF-8";

		// 3. ���ε� ��ġ
		String saveFolder = "Z:\\upload";

		// 4. ���ε带 ���� Request ��ü�� ���� : MultipartRequest
		try {
			MultipartRequest multiReq = 
					new MultipartRequest(
							request,
							saveFolder,
							uploadFileSize,
							encodingType,
							new DefaultFileRenamePolicy()
							);
			if(multiReq == null) {
				System.out.println("���ε� ����");
			} else {
				System.out.println("���ε� ����");
			}
			
			Enumeration<String> fileNames = multiReq.getFileNames();
			while(fileNames.hasMoreElements()) {
				String file = fileNames.nextElement(); // �����̸� X => ���ε�� name�� ����� �̸�
				String fileName = multiReq.getFilesystemName(file); // ����� ���� ���ϸ�
				
				String originalFileName = multiReq.getOriginalFileName(file);
											// ��å�� ���ؼ� ����Ǳ� �� ���ϸ�
				
				
				out.println("���ε�� ���ϸ� : " + fileName + "<br>");
				out.println("���ε�� ���� ���ϸ� : " + originalFileName + "<br>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
