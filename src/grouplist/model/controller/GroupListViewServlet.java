package grouplist.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import group.model.vo.Group;
import grouplist.model.service.GroupListService;
import grouplist.model.vo.GroupListViewData;


/**
 * Servlet implementation class GroupListViewServlet
 */
@WebServlet(name = "GroupListView", urlPatterns = { "/groupListView" })
public class GroupListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupListViewServlet() {
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
		int groupCategory = Integer.parseInt(request.getParameter("groupCategory"));
		System.out.println("서블릿 ");
		System.out.println(groupCategory);
		//3. 비지니스로직
		Group g = new Group();
		GroupListViewData glvd = new GroupListService().selectGroupListView(reqPage,groupCategory);
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/grouplist/groupListView.jsp");
		request.setAttribute("groupCategory", groupCategory);
		request.setAttribute("list", glvd.getList());
		request.setAttribute("pageNavi", glvd.getPageNavi());
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
