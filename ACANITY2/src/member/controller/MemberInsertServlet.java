package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/menroll")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html; charset=utf-8");
	      
	      String memberId = request.getParameter("m_id");
	      String memberPw = request.getParameter("m_pw");
	      String memberName = request.getParameter("m_name");
	      String memberClass = request.getParameter("m_class");
	      String memberTime = request.getParameter("m_time");
	      String memberTel = request.getParameter("m_tel");
	      String memberEmail = request.getParameter("m_email");
	      
	      
	      Member member = new Member(memberId, memberPw, memberName, memberClass, memberTime, memberTel, memberEmail);
	      int result = new MemberService().insertMember(member);
	      
	      if(result >= 0){
	         response.sendRedirect("/acanity/index.jsp");

	      }else {
	         RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
	         request.setAttribute("message", "회원 가입 실패!");
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
