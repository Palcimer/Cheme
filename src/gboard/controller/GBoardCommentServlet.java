package gboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gboard.model.service.GBoardService;
import gboard.model.vo.GBoardComment;

/**
 * Servlet implementation class GBoardCommentServlet
 */
@WebServlet(name = "GBoardComment", urlPatterns = { "/gBoardComment" })
public class GBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rpWriter = Integer.parseInt(request.getParameter("rpWriter"));
		int rpLv = Integer.parseInt(request.getParameter("rpLv"));
		int rpRef = Integer.parseInt(request.getParameter("rpRef"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String rpContent = request.getParameter("rpContent");
		int mem = Integer.parseInt(request.getParameter("mem"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		GBoardComment cmt = new GBoardComment(0, boardNo, rpContent, rpWriter, null, rpLv, rpRef, null);
		int result = new GBoardService().insertBoardCmt(cmt);
		if(result > 0) {
			response.sendRedirect("/gBoardView?groupId=" + groupId + "&boardNo=" + boardNo + "&mem=" + mem);
		} else {			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "댓글을 다는 중 에러가 발생했습니다.");
			request.setAttribute("loc", "/gBoardView?groupId=" + groupId + "&boardNo=" + boardNo + "&mem=" + mem);
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
