package post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import post.model.service.SharePostService;
import post.model.vo.Post;

@WebServlet("/splist")
public class SharePostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SharePostListServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글 리스트 보기 처리용 컨트롤러
		
		//가짜데이터
		Member member = new Member("아이디", "비밀번호", "이름", "A", "오전", "01091901099", "이메일");
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		response.setContentType("text/html; charset=utf-8");
		ArrayList<Post> list = new SharePostService().selectList(cno);
		RequestDispatcher view = null;
		if (list != null){
			view = request.getRequestDispatcher("views/post/shareListView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/post/shareError.jsp");
			request.setAttribute("message", "리스트 불러오기 실패");
			view.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
