package gboard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gboard.model.service.GBoardService;
import gboard.model.vo.GBoard;
import gnotice.model.vo.GNotice;

/**
 * Servlet implementation class DelGBoardServlet
 */
@WebServlet(name = "DelGBoard", urlPatterns = { "/delGBoard" })
public class DelGBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelGBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		GBoardService gbs = new GBoardService();
		GBoard board = gbs.selectBoard(boardNo);
		int result = gbs.deleteBoard(boardNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			if(board.getgBoardFilepath() != null) { //첨부파일이 있으면(파일패스가 null이 아니면)
				String root = getServletContext().getRealPath("/");
				String file = root + "upload/group/" + board.getgBoardFilepath();
				File delFile = new File(file);
				delFile.delete();
			}
			request.setAttribute("msg", "삭제되었습니다.");
			request.setAttribute("loc", "/gBoardList?groupId=" + board.getGroupId() + "&mem=" + board.getgBoardWriter() + "&page=1");
		} else {
			request.setAttribute("msg", "삭제에 실패했습니다.");
			request.setAttribute("loc", "/gBoardView?boardNo=" + boardNo + "&groupId=" + board.getGroupId() + "&mem=" + board.getgBoardWriter());
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
