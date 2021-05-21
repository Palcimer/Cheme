package group.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group.model.service.GroupService;

/**
 * Servlet implementation class JoinGroup
 */
@WebServlet("/joinGroup")
public class JoinGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int memberNo = Integer.parseInt(request.getParameter("mem"));
		GroupService gs = new GroupService();
		int result = gs.insertMember(groupId, memberNo);
		if(result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "모임에 가입되었습니다.");
			request.setAttribute("loc", "/groupDetail?Id=" + groupId + "&mem=" + memberNo);
			rd.forward(request, response);			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "에러가 발생했습니다.");
			request.setAttribute("loc", "/groupDetail?Id=" + groupId + "&mem=" + memberNo);
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
