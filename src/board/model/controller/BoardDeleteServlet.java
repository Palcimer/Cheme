package board.model.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;


/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet(name = "BoardDelete", urlPatterns = { "/boardDelete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		//3. 비지니스로직
		BoardService service = new BoardService();
		Board b = service.selectOneBoard(boardNo);
		int result = service.deleteBoard(boardNo);
		//4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			if(b.getFilePath() != null) {//삭제한 공지사항이 첨부파일이 있는경우
				String root = getServletContext().getRealPath("/");
				String file = root+"upload/board/"+b.getFilePath();
				File delFile = new File(file);	//java.io.File
				delFile.delete();
			}
			request.setAttribute("msg", "삭제 성공");
			request.setAttribute("loc", "/board?reqPage=1");
		}else {
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("loc", "/boardView?boardNo="+boardNo);
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
