package post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.SharePostService;

@WebServlet("/spdelete")
public class SharePostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SharePostDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글 삭제 처리용 컨트롤러
		int pno = Integer.parseInt(request.getParameter("pno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		int result = new SharePostService().deletePost(pno, cno);
		
		RequestDispatcher view = null;
		if(result > 0){
			response.sendRedirect("/acanity/splist?cno=" + cno);
		}else{
			view = request.getRequestDispatcher("views/post/shareError.jsp");
			request.setAttribute("message", "삭제 후 리스트 불러오기 실패");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
