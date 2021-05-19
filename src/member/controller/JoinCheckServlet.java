package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class JoinCheckServlet
 */
@WebServlet(name = "JoinCheck", urlPatterns = { "/joinCheck" })
public class JoinCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
				request.setCharacterEncoding("utf-8");
				//2. 값추출
				String memberId = request.getParameter("memberId");
				String memberPw = request.getParameter("memberPw");
				//3. 로직처리 -> 비지니스로직 -> 서비스호출
				Member m = new MemberService().selectOneMember(memberId,memberPw);
				//4. 결과처리
				//결처리용 페이지 지정
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				//로그인 성공한경우(memberLevel==3,!==3, 로그인 실패한경우
				//해당하는 경우에 따라서 msg.jsp에서 사용할 변수의 값을 다르게 적용
				if(m != null ) {
					//로그인성공
					HttpSession session = request.getSession();
					session.setAttribute("m", m);
					request.setAttribute("msg", "로그인성공");
				}else {
					//로그인 실패한경우
					
					request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
				}
//				alert으로 안내 후 이동할 페이지 지정
				request.setAttribute("loc", "/");
				//페이지 이동
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













