package gallery.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gallery.model.service.GalleryService;
import gallery.model.vo.GalleryComment;

/**
 * Servlet implementation class GalleryCommentUpdateServlet
 */
@WebServlet(name = "GalleryCommentUpdate", urlPatterns = { "/galleryCommentUpdate" })
public class GalleryCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int galleryNo = Integer.parseInt(request.getParameter("galleryNo"));
		int galleryCommentNo = Integer.parseInt(request.getParameter("galleryCommentNo"));
		String galleryCommentContent = request.getParameter("galleryCommentContent");
		
		int result = new GalleryService().updateGalleryComment(galleryCommentContent,galleryCommentNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "수정완료");
		}else {
			request.setAttribute("msg", "수정실패");
		}
		request.setAttribute("loc", "/galleryView?galleryNo="+galleryNo);
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
