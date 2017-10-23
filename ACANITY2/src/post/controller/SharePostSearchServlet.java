package post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.SharePostService;
import post.model.vo.Post;

@WebServlet("/spsearch")
public class SharePostSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SharePostSearchServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글 검색 처리용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		ArrayList<Post> list = new SharePostService().selectSearch(title, cno);
		
		RequestDispatcher view = null;
		if (list != null){
			view = request.getRequestDispatcher("views/post/shareListView.jsp?cno=" + cno);
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
