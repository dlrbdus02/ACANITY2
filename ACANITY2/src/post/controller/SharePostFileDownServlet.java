package post.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/spfiledown")
public class SharePostFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SharePostFileDownServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*int cno = Integer.parseInt(request.getParameter("cno"));
		int pno = Integer.parseInt(request.getParameter("pno"));*/
		int count = Integer.parseInt(request.getParameter("count"));
		String filenames = request.getParameter("files");

		String[] first = new String[2];
		String[] second = new String[2];
		String[] third = new String[2];
		String[] temp = null;
		String[] rnames = null;
		String[] onames = null;
		
		switch(count){
		case 1:
			first = filenames.split("/");
			rnames = new String[1];
			onames = new String[1];
			rnames[0] = first[0];
			onames[0] = first[1];
			break;
		case 2:
			temp = new String[2];
			temp = filenames.split(",");
			first = temp[0].split("/");
			second = temp[1].split("/");
			rnames = new String[2];
			onames = new String[2];
			rnames[0] = first[0];
			onames[0] = first[1];
			rnames[1] = second[0];
			onames[1] = second[1];
			break;
		case 3:
			temp = new String[3];
			temp = filenames.split(",");
			first = temp[0].split("/");
			second = temp[1].split("/");
			third = temp[2].split("/");
			rnames = new String[3];
			onames = new String[3];
			rnames[0] = first[0];
			onames[0] = first[1];
			rnames[1] = second[0];
			onames[1] = second[1];
			rnames[2] = third[0];
			onames[2] = third[1];
			break;
		}
		
		//파일 다운로드 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		//프로젝트 내에 저장된 파일의 폴더 경로정보 알아냄
		String savePath = request.getSession().getServletContext()
				.getRealPath("/uploadfiles");
		
		for(int i=0; i<count; i++){
			File downFile = new File(savePath + "/" + rnames[i]);
			
			//클라이언트로 내보낼 출력 스트림 생성
			ServletOutputStream downOut = response.getOutputStream();
			response.setContentType("text/plane; charset=utf-8");
			
			//한글 파일명 인코딩 처리함 : 받아주는 시스템의 인코딩으로 변환함
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ new String(onames[i].getBytes("utf-8"), "ISO-8859-1") + "\"");
			response.setContentLength((int)downFile.length());
			
			//저장된 폴더에서 파일을 읽어서, 클라이언트한테 내보내기 : 파일 다운
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
			
			int read = -1;
			while((read = bin.read()) != -1){
				downOut.write(read);
				downOut.flush();
			}
			downOut.close();
			bin.close();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
