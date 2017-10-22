package post.model.vo;

import java.sql.Date;

public class Post implements java.io.Serializable {
   
   // Field
   private int pNo;      //게시글 번호
   private int pCode;   //분류 코드(QnA게시글:1, 자료공유게시글:2)
   private String pTitle;   //제목
   private String pContent;//내용
   private int readCount;   //조회수
   private Date pDate;      //작성일
   private int pOpen;   //공개여부(공개:0, 비공개:1)
   private String pPw;      //비밀번호
   private String originalFileName;   //원래 파일명
   private String renameFileName;      //수정 파일명
   private String pId;      //작성자
   private int depth;      //깊이(자주묻는질문:0, 게시물:1, 댓글:2)
   private int refNo;      //참조글번호
   private int cNo;      //모임번호      **자료공유게시판에서 필요

   private static final long serialVersionUID = 10000L;   //직렬화 아이디
   
   // Constructor : default
   public Post(){}

   // Constructor : all
   public Post(int pNo, int pCode, String pTitle, String pContent, int readCount, Date pDate, int pOpen, String pPw,
			String originalFileName, String renameFileName, String pId, int depth, int refNo, int cNo) {
		super();
		this.pNo = pNo;
		this.pCode = pCode;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.readCount = readCount;
		this.pDate = pDate;
		this.pOpen = pOpen;
		this.pPw = pPw;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
		this.pId = pId;
		this.depth = depth;
		this.refNo = refNo;
		this.cNo = cNo;
	}

   // Getter & Setter
	public int getpNo() {
		return pNo;
	}
	
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	
	public int getpCode() {
		return pCode;
	}
	
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	
	public String getpTitle() {
		return pTitle;
	}
	
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	
	public String getpContent() {
		return pContent;
	}
	
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	
	public int getReadCount() {
		return readCount;
	}
	
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public Date getpDate() {
		return pDate;
	}
	
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
	public int getpOpen() {
		return pOpen;
	}
	
	public void setpOpen(int pOpen) {
		this.pOpen = pOpen;
	}
	
	public String getpPw() {
		return pPw;
	}
	
	public void setpPw(String pPw) {
		this.pPw = pPw;
	}
	
	public String getOriginalFileName() {
		return originalFileName;
	}
	
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	
	public String getRenameFileName() {
		return renameFileName;
	}
	
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	
	public String getpId() {
		return pId;
	}
	
	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getRefNo() {
		return refNo;
	}
	
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	
	public int getcNo() {
		return cNo;
	}
	
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

   @Override
   public String toString(){
      return pNo + ", " + cNo + ", "+ pCode + ", " + pTitle + ", " + pContent + ", " + readCount + ", " +
            pDate + ", " + pOpen + ", " + pPw + ", " + originalFileName + ", " + renameFileName + ", " +
            pId + ", " + depth + ", " + refNo + ", " + cNo;
   }

}