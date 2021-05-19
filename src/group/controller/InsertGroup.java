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

import group.model.service.GroupService;
import group.model.vo.Group;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		2.값추출
		if (!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "모임 작성 오류[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		// 파일 업로드 준비
		// 1) v파일 업로드 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/grouprepresenphoto";
		// 2) 파일 최대크기지정
		int maxSize = 10 * 1024 * 1024;

		// 3) request -> MultipartRequest변환 파일을 업로드
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		Group g = new Group();
		String cate = mRequest.getParameter("moimCategori"); 
		if (cate.equals("여행")) {
			g.setGroupCategory(1);
		}else if(cate.equals("스포츠")) {
			g.setGroupCategory(2);
		}else if(cate.equals("공연전시")) {
			g.setGroupCategory(3);
		}else if(cate.equals("이벤트")) {
			g.setGroupCategory(4);
		}else if(cate.equals("게임")) {
			g.setGroupCategory(5);
		}else if(cate.equals("공예")) {
			g.setGroupCategory(6);
		}else if(cate.equals("음악")) {
			g.setGroupCategory(7);
		}else if(cate.equals("그림")) {
			g.setGroupCategory(8);
		}else if(cate.equals("사진")) {
			g.setGroupCategory(9);
		}else if(cate.equals("어학")) {
			g.setGroupCategory(10);
		}else if(cate.equals("독서")) {
			g.setGroupCategory(11);
		}else if(cate.equals("가술")) {
			g.setGroupCategory(12);
		}else if(cate.equals("제태크")) {
			g.setGroupCategory(13);
		}else if(cate.equals("기타")) {
			g.setGroupCategory(14);
		}
		
		g.setGroupDetail(mRequest.getParameter("moimIntro"));
		g.setGroupImg(mRequest.getFilesystemName("moimPicture"));
		g.setGroupLeader(Integer.parseInt(mRequest.getParameter("memberNo")));
		g.setGroupName(mRequest.getParameter("moimName"));
		g.setKeyword1(mRequest.getParameter("moimKeyword1"));
		g.setKeyword2(mRequest.getParameter("moimKeyword2"));
		g.setKeyword3(mRequest.getParameter("moimKeyword3"));
		g.setKeyword4(mRequest.getParameter("moimKeyword4"));
		g.setKeyword5(mRequest.getParameter("moimKeyword5"));
		g.setMaxMember(Integer.parseInt(mRequest.getParameter("moimMax")));
		
//		3.비지니스 로직
		int result = new GroupService().insertGroup(g);
//		4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "성공");
		}else {
			request.setAttribute("msg", "오류");
		}
		request.setAttribute("loc", "/");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
