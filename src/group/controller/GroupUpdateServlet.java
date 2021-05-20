package group.controller;

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

import group.model.service.GroupService;
import group.model.vo.Group;

/**
 * Servlet implementation class GroupUpdateServlet
 */
@WebServlet(name = "GroupUpdate", urlPatterns = { "/groupUpdate" })
public class GroupUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
		
		String filename = mRequest.getOriginalFileName("moimPicture");
		if(filename == null) {
			filename= mRequest.getParameter("oldFilename");
		}
				
		g.setGroupDetail(mRequest.getParameter("moimIntro"));
		g.setGroupImg(filename);
		g.setGroupLeader(1); // TODO: 로그인 구현 후 수정
		g.setGroupName(mRequest.getParameter("moimName"));
		g.setKeyword1(mRequest.getParameter("moimKeyword1"));
		g.setKeyword2(mRequest.getParameter("moimKeyword2"));
		g.setKeyword3(mRequest.getParameter("moimKeyword3"));
		g.setKeyword4(mRequest.getParameter("moimKeyword4"));
		g.setKeyword5(mRequest.getParameter("moimKeyword5"));
		g.setMaxMember(Integer.parseInt(mRequest.getParameter("moimMax")));
		g.setGroupId(Integer.parseInt(mRequest.getParameter("groupId")));
		
		
//		3.비지니스 로직
		int result = new GroupService().modifyGroup(g);
//		4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "수정 성공");
		}else {
			request.setAttribute("msg", "수정 실패");
		}
		request.setAttribute("loc", "/");
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
