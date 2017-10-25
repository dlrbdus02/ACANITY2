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
   public ArrayList<Post> selectSearch(String title, int cno){
      Connection conn = getConnection();
      ArrayList<Post> list = new SharePostDao().selectSearch(conn, title, cno);
      close(conn);
      return list;
   }
   
   // 게시글 상세보기
   public Post selectPost(int no, int cno){
      Connection conn = getConnection();
      Post post = new SharePostDao().selectPost(conn, no, cno);
      close(conn);
      return post;
   }
   
   // 게시글 등록
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
   
   // 게시글 수정
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
   
   // 게시글 삭제
   public int deletePost(int no, int cno){
      Connection conn = getConnection();
      int result = new SharePostDao().deletePost(conn, no, cno);
      if (result > 0)
         commit(conn);
      else
         rollback(conn);
      close(conn);
      return result;
   }
   
   // 조회수 1 증가
   public void addReadCount(int no, int cno) {
      Connection conn = getConnection();
      int result = new SharePostDao().addReadCount(conn, no, cno);
      if(result > 0)
         commit(conn);
      else
         rollback(conn);
      close(conn);
   }
   
   public int getNextNumber(int cno){
	   Connection conn = getConnection();
	   int no = new SharePostDao().getNextNumber(conn, cno);
	   close(conn);
	   return no;
   }
}