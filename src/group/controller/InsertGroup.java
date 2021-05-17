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


/**
 * Servlet implementation class InsertGroup
 */
@WebServlet("/insertGroup")
public class InsertGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
//		2.값추출
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "모임 작성 오류[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		//파일 업로드 준비
		//1) v파일 업로드 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/grouppicture";
		//2) 파일 최대크기지정
		int maxSize = 10*1024*1024;
		
		//3) request -> MultipartRequest변환 파일을 업로드
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		//
		String moimName = mRequest.getParameter("moimName");
		String moimCategori = mRequest.getParameter("moimCategori");
		int moimMax = Integer.parseInt(mRequest.getParameter("moimMax"));
		String moimIntro = mRequest.getParameter("moimIntro");
		String moimKeyword1 = mRequest.getParameter("moimKeyword1");
		String moimKeyword2 = mRequest.getParameter("moimKeyword2");
		String moimKeyword3 = mRequest.getParameter("moimKeyword3");
		String moimKeyword4 = mRequest.getParameter("moimKeyword4");
		String moimKeyword5 = mRequest.getParameter("moimKeyword5");
		String filename = mRequest.getFilesystemName("moimPicture");
		
		
		System.out.println(moimName);
		System.out.println(moimCategori);
		System.out.println(moimIntro);
		System.out.println(moimMax);
		System.out.println(moimKeyword1);
		System.out.println(moimKeyword2);
		System.out.println(filename);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
