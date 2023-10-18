package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ex01_fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		
		// ���ε�� ������ �����ϱ� ���� ��� �غ�

		// 1. ������ ũ�⸦ ����
		int uploadFileSize = 5 * 1024 * 1024;
		// 		����Ʈ ���� : 5MB = 5(KB) * 1024 = 5(byte) * 1024 * 1024
		
		// 2. ���� �̸� ���ڵ� ��� : UTF-8
		String encodingType = "UTF-8";
		
		// 3. ���ε� ��ġ
		String saveFolder = "upload";
		
		ServletContext context = getServletContext();
		String uploadFileFolder = context.getRealPath(saveFolder);
		System.out.println("�������� ���� ��� : " + uploadFileFolder);
		
		// 4. ���ε带 ���� Request ��ü�� ���� : MultipartRequest
		try {
			MultipartRequest multiReq = new MultipartRequest(
				request, // ������ ���� ���� request ��ü
				uploadFileFolder, // ���ε� ��ġ
				uploadFileSize, // ���� ������
				encodingType, // ���ڵ� ���
				new DefaultFileRenamePolicy() // ��å : ������ �̸��� ������ ������ ��� ó���� ��ħ(ex. image.jpg -> image(1).jpg...)
				); 
			String fileName = multiReq.getFilesystemName("uploadFile");
			// ���������� ���εǰ� �Ǿ��ٸ� ����� ���� �̸��� �о�´�.
			
			if(fileName == null) {
				System.out.println("���� ���ε� ����");
			}else {
				out.println("�۾��� : " + multiReq.getParameter("name") + "<br>");
				out.println("��   �� : " + multiReq.getParameter("title") + "<br>");
				out.println("���ϸ� : " + fileName + "<br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
