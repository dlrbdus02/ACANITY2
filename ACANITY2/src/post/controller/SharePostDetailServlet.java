package post.controller;

import java.io.IOException;
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
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 조회수 1 증가 처리
		new SharePostService().addReadCount(no);
		Post post = new SharePostService().selectPost(no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
