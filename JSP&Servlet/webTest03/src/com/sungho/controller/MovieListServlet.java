package com.sungho.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sungho.dao.MovieDAO;
import com.sungho.vo.MovieVO;

@WebServlet("/movieList")
public class MovieListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDAO dao = MovieDAO.getInstance();
		List<MovieVO> list = dao.selectMovieAll();
		
		request.setAttribute("movie", list);
		
		request.getRequestDispatcher("movie/movieList.jsp").forward(request, response);
	}

}
