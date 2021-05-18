package gnotice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gnotice.model.service.GNoticeService;
import gnotice.model.vo.GNoticeComment;

/**
 * Servlet implementation class GNoticeCommentServlet
 */
@WebServlet(name = "GNoticeComment", urlPatterns = { "/gNoticeComment" })
public class GNoticeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeCommentServlet() {
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
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String rpContent = request.getParameter("rpContent");
		GNoticeComment cmt = new GNoticeComment(0, rpLv, rpRef, noticeNo, null, rpWriter, rpContent, null);
		int result = new GNoticeService().insertNoticeCmt(cmt);
		if(result > 0) {
			response.sendRedirect("/gNoticeView?noticeNo=" + noticeNo);
		} else {			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "에러가 발생했습니다.");
			request.setAttribute("loc", "/gNoticeView?noticeNo=" + noticeNo);
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
