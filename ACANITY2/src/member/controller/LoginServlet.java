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

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 요청 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	
		String memberId = request.getParameter("m_id");
		String memberPwd = request.getParameter("m_pw");
		
		MemberService mservice = new MemberService();
		Member member = mservice.loginCheck(memberId, memberPwd);
		
		RequestDispatcher view = null;
		if(member != null){
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			if(memberId.equals("admin")){
				ArrayList<Member> mlist = mservice.selectAll();
				view = request.getRequestDispatcher("views/member/memberListView.jsp");
				request.setAttribute("list", mlist);
				view.forward(request, response);
			
			}else 
				response.sendRedirect("/acanity/index.jsp");
			
		}else {
			view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "로그인 실패... 아이디 또는 암호를 확인하세요.");
			view.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
