package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group.model.service.GroupService;
import group.model.vo.Group;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageFrm
 */
@WebServlet("/myPageFrm")
public class MyPageFrm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageFrm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		Member m =(Member)session.getAttribute("m");
		//3.비지니스 로직
		Member member = new MemberService().selectOneMember(m.getMemberId(),m.getMemberPw());
		//본인이 일반 회원으로 소속되어있는 그룹 리스트
		ArrayList<Integer> groupIdList = new GroupService().selectGroupId(m.getMemberNo());
		//본인이 리더로서 속해있는 그룹 리스트
		ArrayList<Integer> gLeaderList = new GroupService().selectGroupLeader(m.getMemberNo());
		
		//리스트에 들어있는 그룹 아이디를 통해서 사진, 그룹 명, 그룹 아이디을 받아오기
		ArrayList<Group> groupAsMemberList = new GroupService().selectGroupAsList(groupIdList);
		ArrayList<Group> groupAsLeaderList = new GroupService().selectGroupAsList(gLeaderList);
		
		
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/myPage.jsp");
		request.setAttribute("member", member);
		request.setAttribute("groupAsMemberList", groupAsMemberList);
		request.setAttribute("groupAsLeaderList", groupAsLeaderList);
	
	      
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
