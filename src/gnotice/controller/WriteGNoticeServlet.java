package gnotice.controller;

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

import gnotice.model.service.GNoticeService;
import gnotice.model.vo.GNotice;

/**
 * Servlet implementation class WriteGNoticeServlet
 */
@WebServlet(name = "WriteGNotice", urlPatterns = { "/writeGNotice" })
public class WriteGNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteGNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일업로드 전처리 시작
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "공지사항 작성오류[enctype]");
			request.setAttribute("loc", "/writeGNoticeFrm");
			rd.forward(request, response);
			return;
		}
		//1) 파일업로드 경로 지정
		String root = getServletContext().getRealPath("/"); //webcontent 폴더
		String saveDir = root + "upload/group"; //파일저장경로
		//2) 업로드 파일의 최대크기 지정(10메가)
		int maxSize = 10*1024*1024;
		//3) request->MultipartRequest 객체로 변환
		//매개변수: request 객체, 파일저장경로, 최대크기, 인코딩타입, 파일명 중복 처리 객체
		MultipartRequest mRequest = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//파일업로드 전처리 완료
		//값 가져오기
		GNotice notice = new GNotice();	
		notice.setgNoticeWriter(Integer.parseInt(mRequest.getParameter("noticeWriter")));
		notice.setgNoticeContent(mRequest.getParameter("noticeContent"));
		notice.setgNoticeTitle(mRequest.getParameter("noticeTitle"));
		notice.setGroupId(Integer.parseInt(mRequest.getParameter("groupId")));
		notice.setFilename(mRequest.getOriginalFileName("noticeFile"));
		notice.setFilepath(mRequest.getFilesystemName("noticeFile"));
		
		int result = new GNoticeService().insertNotice(notice);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "공지사항 등록 성공");
		} else {
			request.setAttribute("msg", "공지사항 등록 실패");
		}
		request.setAttribute("loc", "/gNoticeList?groupId=" + notice.getGroupId() + "&mem=" + notice.getgNoticeWriter() + "&page=1");
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
