package post.controller;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import post.model.service.SharePostService;
import post.model.vo.Post;

@WebServlet("/spinsert")
public class SharePostInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SharePostInsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일 공유 게시판 : 게시글, 댓글 등록 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		int size = 10 * 1024 * 1024;

		// multipart/form-data 형식으로 전송되지 않았으면 에러페이지
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("acanity/views/postError.jsp");
			request.setAttribute("message", "Form enctype 속성 사용 안 함");
			view.forward(request, response);
		}

		SharePostService spservice = new SharePostService();

		int cno = Integer.parseInt(request.getParameter("cno"));
		String root = request.getSession().getServletContext().getRealPath("/");
		String uploadPath = root + "suploadfiles";

		// request, 업로드경로, 파일최대크기, 한글처리, 파일중복처리
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
				new DefaultFileRenamePolicy());

		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String pwd = multi.getParameter("pwd");

		String originalFileName = multi.getFilesystemName("upfile");
		Post p = null;
		// Enumeration files = multi.getFileNames();
		// while(files.hasMoreElements()){
		// String file = (String)files.nextElement();
		if (originalFileName != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

			// 업로드되어 있는 원래 파일의 이름을 새 이름으로 바꾸기
			File originalFile = new File(uploadPath + "\\" + originalFileName);
			File renameFile = new File(uploadPath + "\\" + renameFileName);

			// 파일이름 바꾸기 실행 >> 실패시 직접 바꾸기함
			// 새 파일 만들고, 원래 파일의 내용 읽어서 복사 기록하고
			// 원 파일 삭제함
			if (!originalFile.renameTo(renameFile)) {
				int read = -1;
				byte[] buf = new byte[1024];

				FileInputStream fin = new FileInputStream(originalFile);
				FileOutputStream fout = new FileOutputStream(renameFile);

				while ((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);

				fin.close();
				fout.close();
				originalFile.delete();
			}
			int no = spservice.getMaxNumber(cno) + 1;

			p = new Post(no, title, content, pwd, originalFileName, renameFileName, writer, cno);
		} else {
			p = new Post();
		}
	}

	Post post = null;
	int result = new SharePostService().insertPost(post);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
