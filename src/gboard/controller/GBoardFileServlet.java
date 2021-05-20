package gboard.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gboard.model.service.GBoardService;
import gboard.model.vo.GBoard;

/**
 * Servlet implementation class GBoardFileServlet
 */
@WebServlet(name = "GBoardFile", urlPatterns = { "/gBoardFile" })
public class GBoardFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		GBoard board = new GBoardService().selectBoard(boardNo);
		
		//파일 경로 지정
		String root = getServletContext().getRealPath("/");
		String file = root + "/upload/group/" + board.getgBoardFilepath();
		//파일을 서블릿으로 가져오기 위한 객체(스트림+보조스트림)
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		//파일을 사용자에게 전달하는 객체(스트림+보조스트림)
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		String resFilename = ""; //최종파일명 저장 변수
		//다운로드 파일명 인코딩
		boolean bool = request.getHeader("user-agent").indexOf("MSIE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;
		if(bool) { //IE인 경우
			resFilename = URLEncoder.encode(board.getgBoardFilename(), "UTF-8");
			resFilename = resFilename.replaceAll("\\\\",  "%20");
		} else { //그 외의 브라우저
			resFilename = new String(board.getgBoardFilename().getBytes("UTF-8"), "ISO-8859-1");
		}
		//파일다운로드를 위한 HTTP 헤더 설정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + resFilename);
		//파일전송
		while(true) {
			int read = bis.read();
			if(read != -1) {
				bos.write(read);
			} else {
				break;
			}
		}
		bos.close();
		bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
