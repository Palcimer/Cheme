package group.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gnotice.model.service.GNoticeService;
import gnotice.model.vo.GNotice;
import group.model.service.GroupService;
import group.model.vo.Group;

/**
 * Servlet implementation class GroupDetailServlet
 */
@WebServlet(name = "GroupDetail", urlPatterns = { "/groupDetail" })
public class GroupDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupId = Integer.parseInt(request.getParameter("Id"));
		String memNo = request.getParameter("mem");
		int memberNo;
		if(memNo == null) {
			memberNo = 0;
		} else {
			memberNo = Integer.parseInt(memNo);
		}
		GNoticeService gns = new GNoticeService();
		GroupService gs = new GroupService();
		Group group = gs.selectOneGroup(groupId);
		boolean isMem = gs.isMember(groupId, memberNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/groups/groupDetail.jsp");
		if(isMem) {
			ArrayList<GNotice> noticeList = gns.selectNoticeList(groupId);
			request.setAttribute("groupInfo", group);
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("isMem", isMem);
		} else {
			request.setAttribute("groupInfo", group);
			request.setAttribute("isMem", isMem);
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}