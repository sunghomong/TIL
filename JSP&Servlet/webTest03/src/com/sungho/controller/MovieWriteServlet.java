package com.sungho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sungho.dao.MovieDAO;
import com.sungho.vo.MovieVO;

@WebServlet("/movieWrite")
public class MovieWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("movie/movieWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String saveFolder = "Z:\\upload";
		int fileSize = 100 * 1024 * 1024;
		String encType = "UTF-8";

		try {
			MultipartRequest multiReq = new MultipartRequest(request, saveFolder, fileSize, encType,
					new DefaultFileRenamePolicy());
			MovieVO movie = new MovieVO();
			movie.setMovieTitle(multiReq.getParameter("movieTitle"));
			movie.setMovieDirector(multiReq.getParameter("movieDirector"));
			movie.setMainActor(multiReq.getParameter("mainActor"));
			movie.setStealCutUrl(multiReq.getFilesystemName("stealCutUrl"));
			movie.setAsterion(Integer.parseInt(multiReq.getParameter("asterion")));
			movie.setSummary(multiReq.getParameter("summary"));
			
			MovieDAO dao = MovieDAO.getInstance();
			dao.insertmovie(movie);

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("movie");
	}

}
