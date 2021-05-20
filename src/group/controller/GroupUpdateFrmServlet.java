package group.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import group.model.service.GroupService;
import group.model.vo.Group;

/**
 * Servlet implementation class GroupUpdateFrmServlet
 */
@WebServlet(name = "GroupUpdateFrm", urlPatterns = { "/groupUpdateFrm" })
public class GroupUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupUpdateFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		int groupId = Integer.parseInt(request.getParameter("groupNo"));		
		Group g = new GroupService().selectOneGroup(groupId);		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/groups/groupUpdateFrm.jsp");
		request.setAttribute("g", g);
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
