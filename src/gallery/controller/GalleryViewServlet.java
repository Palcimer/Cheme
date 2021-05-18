package gallery.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gallery.model.service.GalleryService;
import gallery.model.vo.GalleryViewData;

/**
 * Servlet implementation class GalleryViewServlet
 */
@WebServlet(name = "GalleryView", urlPatterns = { "/galleryView" })
public class GalleryViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int galleryNo = Integer.parseInt(request.getParameter("galleryNo"));
		
		GalleryViewData gvd = new GalleryService().selectGalleryView(galleryNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/gallery/galleryView.jsp");
		request.setAttribute("n", gvd.getG());
		request.setAttribute("list", gvd.getList());
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
