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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		// 저장 경로
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "uploadfiles";
		
		// 파일 최대 크기
		int MaxSize = 10 * 1024 * 1024;

		// get으로 전달받은 값
		int cno = Integer.parseInt(request.getParameter("cno"));

		SharePostService spservice = new SharePostService();
		RequestDispatcher view = null;
		
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("acanity/views/postError.jsp");
			request.setAttribute("message", "Form enctype 속성 사용 안 함");
			view.forward(request, response);
		}
		
		// request, 업로드경로, 파일최대크기, 한글처리, 파일중복처리
		MultipartRequest multi = new MultipartRequest(request, savePath, MaxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String pwd = multi.getParameter("pwd");
		
		String oname1 = multi.getFilesystemName("uploadfile1");
		String oname2 = multi.getFilesystemName("uploadfile2");
		String oname3 = multi.getFilesystemName("uploadfile3");

		Post post = null;
		String onames = null;
		String rnames = null;

		int no = spservice.getNextNumber(cno);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		if(oname1 != null){
			String rname1 = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "1."
					+ oname1.substring(oname1.lastIndexOf(".") + 1);
			
			//업로드되어 있는 원래 파일의 이름을 새 이름으로 바꾸기
			File originalFile = new File(savePath + "\\" + oname1);
			File renameFile = new File(savePath + "\\" + rname1);
			
			//파일이름 바꾸기 실행 >> 실패시 직접 바꾸기함
			//새 파일 만들고, 원래 파일의 내용 읽어서 복사 기록하고
			//원 파일 삭제함
			if(!originalFile.renameTo(renameFile)){
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originalFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);
				
				fin.close();
				fout.close();
				originalFile.delete();
			}
			onames += oname1;
			rnames += rname1;
		}
		
		if(oname2 != null){
			String rname2 = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "2."
					+ oname2.substring(oname2.lastIndexOf(".") + 1);
			
			//업로드되어 있는 원래 파일의 이름을 새 이름으로 바꾸기
			File originalFile = new File(savePath + "\\" + oname2);
			File renameFile = new File(savePath + "\\" + rname2);
			
			//파일이름 바꾸기 실행 >> 실패시 직접 바꾸기함
			//새 파일 만들고, 원래 파일의 내용 읽어서 복사 기록하고
			//원 파일 삭제함
			if(!originalFile.renameTo(renameFile)){
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originalFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);
				
				fin.close();
				fout.close();
				originalFile.delete();
			}
			if(oname1 != null){
				onames += ",";
				rnames += ",";
			}
			onames += oname2;
			rnames += rname2;
		}
		
		if(oname3 != null){
			String rname3 = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "3."
					+ oname3.substring(oname3.lastIndexOf(".") + 1);
			
			//업로드되어 있는 원래 파일의 이름을 새 이름으로 바꾸기
			File originalFile = new File(savePath + "\\" + oname3);
			File renameFile = new File(savePath + "\\" + rname3);
			
			//파일이름 바꾸기 실행 >> 실패시 직접 바꾸기함
			//새 파일 만들고, 원래 파일의 내용 읽어서 복사 기록하고
			//원 파일 삭제함
			if(!originalFile.renameTo(renameFile)){
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originalFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);
				
				fin.close();
				fout.close();
				originalFile.delete();
			}
			if(oname2 != null || oname1 != null){
				onames += ",";
				rnames += ",";
			}
			onames += oname3;
			rnames += rname3;
		}
		post = new Post(no, title, content, pwd, onames, rnames, writer, cno);
		
		if(spservice.insertPost(post) > 0){
			response.sendRedirect("/acanity/splist?cno=" + cno);
		}else{
			view = request.getRequestDispatcher("views/post/shareError.jsp");
			request.setAttribute("message", "게시글 등록 실패");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
