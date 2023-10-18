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

		// 1. 파일의 크기를 지정
		int uploadFileSize = 5 * 1024 * 1024;
		// 업로드된 모든 파일 크기의 합계

		// 2. 파일 이름 인코딩 방식 : UTF-8
		String encodingType = "UTF-8";

		// 3. 업로드 위치
		String saveFolder = "Z:\\upload";

		// 4. 업로드를 위한 Request 객체를 생성 : MultipartRequest
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
				System.out.println("업로드 실패");
			} else {
				System.out.println("업로드 성공");
			}
			
			Enumeration<String> fileNames = multiReq.getFileNames();
			while(fileNames.hasMoreElements()) {
				String file = fileNames.nextElement(); // 파일이름 X => 업로드시 name에 저장된 이름
				String fileName = multiReq.getFilesystemName(file); // 저장된 실제 파일명
				
				String originalFileName = multiReq.getOriginalFileName(file);
											// 정책에 의해서 변경되기 전 파일명
				
				
				out.println("업로드된 파일명 : " + fileName + "<br>");
				out.println("업로드된 원본 파일명 : " + originalFileName + "<br>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
