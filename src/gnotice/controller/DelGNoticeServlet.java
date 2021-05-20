package gnotice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gnotice.model.service.GNoticeService;
import gnotice.model.vo.GNotice;

/**
 * Servlet implementation class DelGNoticeServlet
 */
@WebServlet(name = "DelGNotice", urlPatterns = { "/delGNotice" })
public class DelGNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelGNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		GNoticeService gns = new GNoticeService();
		GNotice gn = gns.selectNotice(noticeNo);
		int result = gns.deleteNotice(noticeNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			if(gn.getFilepath() != null) { //첨부파일이 있으면(파일패스가 null이 아니면)
				String root = getServletContext().getRealPath("/");
				String file = root + "upload/group/" + gn.getFilepath();
				File delFile = new File(file);
				delFile.delete();
			}
			request.setAttribute("msg", "삭제되었습니다.");
			request.setAttribute("loc", "/gNoticeList?groupId=" + gn.getGroupId() + "&mem=" + gn.getgNoticeWriter() + "&page=1");
		} else {
			request.setAttribute("msg", "삭제에 실패했습니다.");
			request.setAttribute("loc", "/gNoticeView?noticeNo=" + noticeNo + "&groupId=" + gn.getGroupId() + "&mem=" + gn.getgNoticeWriter());
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
