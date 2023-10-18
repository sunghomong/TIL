package com.green.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;


public class BoardListAction implements Action {
	
	private BoardListAction() {}
	private static BoardListAction bla = new BoardListAction();
	public static BoardListAction getInstance() {
		return bla;
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 실제 게시물 목록을 가져와서 뷰에 연결시켜주는 메서드
		
//		String url = "board/boardList.jsp";
//		
//		BoardDAO dao = BoardDAO.getInstence();
//		List<BoardVO> list = dao.selectAllBoard();
//		
//		request.setAttribute("boardList", list);
//		
//		request.getRequestDispatcher(url).forward(request, response);
		
		
// ----------------------------------------------------------------------------------------------------
		// 페이징 처리가 된 게시물 리스트 가져오기
		String url = "board/boardList.jsp";
		
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		int section = Integer.parseInt((_section == null)?"1":_section);
		int pageNum = Integer.parseInt((_pageNum == null)?"1":_pageNum);
		
		BoardDAO dao = BoardDAO.getInstence();
		int totalCnt = dao.selectAllBoardNum();
		List<BoardVO> list = dao.selectTargetBoard(section, pageNum);
		
		
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("section", section);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
