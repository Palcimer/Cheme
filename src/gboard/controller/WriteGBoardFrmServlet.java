package gboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group.model.service.GroupService;
import group.model.vo.Group;

/**
 * Servlet implementation class WriteGBoardFrmServlet
 */
@WebServlet(name = "WriteGBoardFrm", urlPatterns = { "/writeGBoardFrm" })
public class WriteGBoardFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteGBoardFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		Group group = new GroupService().selectOneGroup(groupId);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/groups/writeGBoard.jsp");
		request.setAttribute("groupId", groupId);
		request.setAttribute("groupName", group.getGroupName());
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
