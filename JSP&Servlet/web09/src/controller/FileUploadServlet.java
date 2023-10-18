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
		
		// 업로드된 파일을 저장하기 위한 몇가지 준비

		// 1. 파일의 크기를 지정
		int uploadFileSize = 5 * 1024 * 1024;
		// 		바이트 단위 : 5MB = 5(KB) * 1024 = 5(byte) * 1024 * 1024
		
		// 2. 파일 이름 인코딩 방식 : UTF-8
		String encodingType = "UTF-8";
		
		// 3. 업로드 위치
		String saveFolder = "upload";
		
		ServletContext context = getServletContext();
		String uploadFileFolder = context.getRealPath(saveFolder);
		System.out.println("서버상의 실제 경로 : " + uploadFileFolder);
		
		// 4. 업로드를 위한 Request 객체를 생성 : MultipartRequest
		try {
			MultipartRequest multiReq = new MultipartRequest(
				request, // 폼으로 부터 얻어온 request 객체
				uploadFileFolder, // 업로드 위치
				uploadFileSize, // 파일 사이즈
				encodingType, // 인코딩 방식
				new DefaultFileRenamePolicy() // 정책 : 동일한 이름의 파일이 존재할 경우 처리할 방침(ex. image.jpg -> image(1).jpg...)
				); 
			String fileName = multiReq.getFilesystemName("uploadFile");
			// 정상적으로 업로되가 되었다면 저장된 파일 이름을 읽어온다.
			
			if(fileName == null) {
				System.out.println("파일 업로드 실패");
			}else {
				out.println("글쓴이 : " + multiReq.getParameter("name") + "<br>");
				out.println("제   목 : " + multiReq.getParameter("title") + "<br>");
				out.println("파일명 : " + fileName + "<br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
