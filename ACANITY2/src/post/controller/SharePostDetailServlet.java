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

@WebServlet("/spdetail")
public class SharePostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SharePostDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글 상세보기 처리용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("pno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		// 조회수 1 증가 처리
		new SharePostService().addReadCount(no, cno);
		Post post = new SharePostService().selectPost(no, cno);
		
		RequestDispatcher view = null;
		if(post != null){
			view = request.getRequestDispatcher("views/post/shareDetailView.jsp");
			request.setAttribute("post", post);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/post/shareError.jsp");
			request.setAttribute("message", "게시글 상세보기 실패");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
