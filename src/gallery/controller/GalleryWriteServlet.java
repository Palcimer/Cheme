package gallery.controller;

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
import group.model.vo.Group;
import member.model.vo.Member;



/**
 * Servlet implementation class GalleryWriteServlet
 */
@WebServlet(name = "GalleryWrite", urlPatterns = { "/galleryWrite" })
public class GalleryWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "게시판 작성 오류 [enctype]");
			request.setAttribute("loc", "/galleryList?reqPage=1");
			rd.forward(request, response);
			return;
		}
		//파일업로드 준비
		//1)파일업로드 경로 설정
	String root = getServletContext().getRealPath("/");
	String saveDirectory = root + "upload/photo";
	//2)파일최대크기 지정
	int maxSize = 10*1024*1024;
	//3)request -> MultipartRequest변환 (파일을 업로드)
	MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
	Gallery ga = new Gallery();
	ga.setGalleryWriter(Integer.parseInt(mRequest.getParameter("galleryWriter"))); 
	ga.setGalleryTitle(mRequest.getParameter("galleryTitle"));
	ga.setGalleryContent(mRequest.getParameter("galleryContent"));
	ga.setGalleryFileName(mRequest.getOriginalFileName("filename")); // 사용자가 업로드한 파일 명
	ga.setGalleryFilepath(mRequest.getFilesystemName("filename"));   // 실제 업로드 된 파일 이름
	ga.setGroupId(Integer.parseInt(mRequest.getParameter("groupId")));
	//3.비즈니스 로직처리
	int result = new GalleryService().insertGallery(ga);
	//4.결과처리
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	if(result>0) {
		request.setAttribute("msg", "등록성공");
	}else {
		request.setAttribute("msg", "등록실패");
	}
	request.setAttribute("loc", "/galleryList?reqPage=1");
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
