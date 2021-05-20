package grouplist.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import grouplist.model.service.GroupListService;
import grouplist.model.vo.GroupListPageData;

/**
 * Servlet implementation class GroupListViewServlet
 */
@WebServlet(name = "GroupList", urlPatterns = { "/groupList" })
public class GroupListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupListServlet() {
    	 super();
         // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		//3. 비지니스로직
		GroupListPageData glpd = new GroupListService().selectGroupList(reqPage);
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/grouplist/grouplist.jsp");
		request.setAttribute("list", glpd.getList());
		request.setAttribute("pageNavi", glpd.getPageNavi());
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
