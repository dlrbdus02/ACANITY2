package post.model.service;

import java.sql.*;
import java.util.*;

import post.model.dao.SharePostDao;
import post.model.vo.Post;
import static common.JDBCTemplate.*;

public class SharePostService {
   
   //Constructor : default
   public SharePostService(){}
   
   // 전체 리스트 불러오기
   public ArrayList<Post> selectList(int cno){
      Connection conn = getConnection();
      ArrayList<Post> list = new SharePostDao().selectList(conn, cno);
      close(conn);      
      return list;
   }
   
   // 제목으로 검색한 리스트 불러오기
   public ArrayList<Post> selectSearch(String title){
      Connection conn = getConnection();
      ArrayList<Post> list = new SharePostDao().selectSearch(conn, title);
      close(conn);
      return list;
   }
   
   // 게시글 상세보기
   public Post selectPost(int no){
      Connection conn = getConnection();
      Post post = new SharePostDao().selectPost(conn, no);
      close(conn);
      return post;
   }
   
   // 게시글 or 댓글 등록
   public int insertPost(Post post){
      Connection conn = getConnection();
      int result = new SharePostDao().insertPost(conn, post);
      if (result > 0)
         commit(conn);
      else
         rollback(conn);
      close(conn);
      return result;
   }
   
   // 게시글 or 댓글 수정
   public int updatePost(Post post){
      Connection conn = getConnection();
      int result = new SharePostDao().updatePost(conn, post);
      if (result > 0)
         commit(conn);
      else
         rollback(conn);
      close(conn);
      return result;
   }
   
   // 게시글 or 댓글 삭제
   public int deletePost(int no, int depth){
      Connection conn = getConnection();
      int result = new SharePostDao().deletePost(conn, no, depth);
      if (result > 0)
         commit(conn);
      else
         rollback(conn);
      close(conn);
      return result;
   }
   
   // 조회수 1 증가
   public void addReadCount(int no) {
      Connection conn = getConnection();
      int result = new SharePostDao().addReadCount(conn, no);
      if(result > 0)
         commit(conn);
      else
         rollback(conn);
      close(conn);
   }
   
   public int getMaxNumber(int cno){
	   Connection conn = getConnection();
	   int no = new SharePostDao().getMaxNumber(conn, cno);
	   close(conn);
	   return no;
   }
}