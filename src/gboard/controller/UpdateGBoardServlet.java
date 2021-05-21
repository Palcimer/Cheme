package gboard.controller;

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

import gboard.model.service.GBoardService;
import gboard.model.vo.GBoard;

/**
 * Servlet implementation class UpdateGBoardServlet
 */
@WebServlet(name = "UpdateGBoard", urlPatterns = { "/updateGBoard" })
public class UpdateGBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGBoardServlet() {
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
			request.setAttribute("msg", "파일오류[enctype]");
			request.setAttribute("loc", "/writeGBoardFrm");
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
		GBoard board = new GBoard();
		board.setGroupId(Integer.parseInt(mRequest.getParameter("groupId")));
		board.setgBoardWriter(Integer.parseInt(mRequest.getParameter("noticeWriter")));
		board.setgBoardNo(Integer.parseInt(mRequest.getParameter("noticeNo")));
		board.setgBoardContent(mRequest.getParameter("noticeContent"));
		board.setgBoardTitle(mRequest.getParameter("noticeTitle"));
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
		//공지 객체에 파일 이름 및 경로 저장 ???
		board.setgBoardFilename(filename);
		board.setgBoardFilepath(filepath);
		
		int result = new GBoardService().updateGBoard(board);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "게시글이 수정되었습니다.");
		} else {
			request.setAttribute("msg", "수정에 실패했습니다.");
		}
		request.setAttribute("loc", "/gBoardView?groupId=" + board.getGroupId() + "&boardNo=" + board.getgBoardNo() + "&mem=" + board.getgBoardWriter());
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
