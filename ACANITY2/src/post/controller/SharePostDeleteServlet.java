package post.controller;

import java.io.IOException;
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
		int no = Integer.parseInt(request.getParameter("pno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		int result = new SharePostService().deletePost(no);
		
		if(result > 0){
			
		}else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
