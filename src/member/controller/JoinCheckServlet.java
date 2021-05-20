package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		//String gender = request.getParameter("gender");
		String gender =request.getParameter("gender");
		String addrcheck = request.getParameter("addrcheck");
		String phone = request.getParameter("phone");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String addr3 = request.getParameter("addr3");
		//3. 비지니스로직
		Member member= new Member(0,id,pw,name,phone,0,gender,addr1+" "+addr2+" "+addr3);
		

		new MemberService().insertMember(member);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/joinmsg.jsp");
		response.setContentType("text/html;charset=utf8");
		PrintWriter writer=response.getWriter();
		if(member!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("mebmer", member);
			
		
		}
		else 
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
		//alert으로 안내 후 이동할 페이지 지정
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
