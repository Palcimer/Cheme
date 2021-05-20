package gboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gboard.model.service.GBoardService;

/**
 * Servlet implementation class ModGBoardCommentServlet
 */
@WebServlet(name = "ModGBoardComment", urlPatterns = { "/modGBoardComment" })
public class ModGBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModGBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cmtNo = Integer.parseInt(request.getParameter("cmtNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int mem = Integer.parseInt(request.getParameter("mem"));
		String gNcContent = request.getParameter("gNcContent");
		GBoardService gbs = new GBoardService();
		int result = gbs.updateBoardCmt(cmtNo, gNcContent);
		if(result > 0) {
			response.sendRedirect("/gBoardView?groupId=" + groupId + "&boardNo=" + boardNo + "&mem=" + mem);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "댓글 수정중 에러가 발생했습니다.");
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
