package gnotice.controller;

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

import gnotice.model.service.GNoticeService;
import gnotice.model.vo.GNotice;

/**
 * Servlet implementation class UpdateGNoticeServlet
 */
@WebServlet(name = "UpdateGNotice", urlPatterns = { "/updateGNotice" })
public class UpdateGNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGNoticeServlet() {
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
		GNotice notice = new GNotice();	
		notice.setgNoticeWriter(Integer.parseInt(mRequest.getParameter("noticeWriter")));
		notice.setgNoticeNo(Integer.parseInt(mRequest.getParameter("noticeNo")));
		notice.setgNoticeContent(mRequest.getParameter("noticeContent"));
		notice.setgNoticeTitle(mRequest.getParameter("noticeTitle"));
		//새 파일 이름 및 경로
		String filename = mRequest.getOriginalFileName("noticeFile");
		String filepath = mRequest.getFilesystemName("noticeFile");
		//기존 파일 이름 및 경로
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		//기존 파일 상태 확인
		String status = mRequest.getParameter("status");
		if(status.equals("del")) { //기존 첨부파일을 삭제했을 때
			File delFile = new File(saveDir + "/" + oldFilepath);
			delFile.delete();
		} else if(oldFilename != null) { //기존 파일이 그대로일 때
			filename = oldFilename;
			filepath = oldFilepath;
		}
		//공지 객체에 파일 이름 및 경로 저장
		notice.setFilename(mRequest.getParameter("filename"));
		notice.setFilepath(mRequest.getParameter("filepath"));
		
		int result = new GNoticeService().updateGNotice(notice);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "공지사항이 수정되었습니다.");
		} else {
			request.setAttribute("msg", "수정에 실패했습니다.");
		}
		request.setAttribute("loc", "/gNoticeView?noticeNo=" + notice.getgNoticeNo());
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
