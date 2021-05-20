package gallery.controller;

import java.io.File;
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

import gallery.model.service.GalleryService;
import gallery.model.vo.Gallery;

/**
 * Servlet implementation class GalleryUpdateServlet
 */
@WebServlet(name = "GalleryUpdate", urlPatterns = { "/galleryUpdate" })
public class GalleryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "갤러리 수정 오류");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/gallery";
		
		int maxSize = 10*1024*1024;
		
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		int galleryNo = Integer.parseInt(mRequest.getParameter("galleryNo"));
		String galleryTitle = mRequest.getParameter("galleryTitle");
		String filename = mRequest.getOriginalFileName("filename");
		String filepath = mRequest.getFilesystemName("filename");
		String galleryContent = mRequest.getParameter("galleryContent");
		
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath"); 
				
		String status = mRequest.getParameter("status");
		if(status.equals("delete")) {
			File delFile = new File(saveDirectory+"/"+oldFilepath);
			delFile.delete();
		}else if(oldFilename != null) {
			filename = oldFilename;
			filepath = oldFilepath;
		}
		Gallery g = new Gallery();
		g.setGalleryNo(galleryNo);
		g.setGalleryTitle(galleryTitle);
		g.setGalleryContent(galleryContent);
		g.setGalleryFileName(filename);
		g.setGalleryFilepath(filepath);
		
		int result = new GalleryService().updateGallery(g);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "글수정 완료");
		}else {
			request.setAttribute("msg", "글수정 실패");
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
