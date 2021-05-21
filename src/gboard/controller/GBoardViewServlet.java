package gboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gboard.model.service.GBoardService;
import gboard.model.vo.GBoardViewData;
import group.model.service.GroupService;

/**
 * Servlet implementation class GBoardViewServlet
 */
@WebServlet(name = "GBoardView", urlPatterns = { "/gBoardView" })
public class GBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		String memNo = request.getParameter("mem");
		int memberNo;
		if(memNo == null) {
			memberNo = 0;
		} else {
			memberNo = Integer.parseInt(memNo);
		}
		GBoardService gbs= new GBoardService();
		GroupService gs = new GroupService();
		boolean isMem = gs.isMember(groupId, memberNo);
		
		if(isMem) {
			GBoardViewData gbvd = gbs.selectBoardData(boardNo);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/groups/gBoardView.jsp");
			System.out.println(gbvd.getBoard().getgBoardTitle());
			request.setAttribute("gName", gbvd.getGroupName());
			request.setAttribute("gBoard", gbvd.getBoard());
			request.setAttribute("cmtList", gbvd.getCmtList());
			rd.forward(request, response);		
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "모임에 가입되어 있지 않습니다.");
			request.setAttribute("loc", "/");
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
