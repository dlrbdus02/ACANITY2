package post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.SharePostService;
import post.model.vo.Post;

@WebServlet("/spupview")
public class SharePostUpViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SharePostUpViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글 수정화면의 기존 정보를 불러오는 컨트롤러
		int no = Integer.parseInt(request.getParameter("pno"));
		int cno = Integer.parseInt(request.getParameter("cno"));

		Post post = new SharePostService().selectPost(no, cno);
		
		RequestDispatcher view = null;
		if(post != null){
			view = request.getRequestDispatcher("views/post/shareUpdateForm.jsp");
			request.setAttribute("post", post);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/post/shareError.jsp");
			request.setAttribute("message", "게시글 수정화면 불러오기 실패");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
