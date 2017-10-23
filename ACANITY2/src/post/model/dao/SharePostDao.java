package post.model.dao;

import java.sql.*;
import java.util.*;

import post.model.vo.Post;
import static common.JDBCTemplate.*;

public class SharePostDao {
   
   //Constructor : default
   public SharePostDao(){}

   public ArrayList<Post> selectList(Connection conn, int cno) {
      // 게시글 리스트 조회
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;
	   ArrayList<Post> list = new ArrayList<Post>();
	   
	   String query = "select p_no, p_title, p_id, p_date, p_readcount "
			   		+ "from post "
			   		+ "where p_code = 2 and p_depth = 1 and c_no = ? "
			   		+ "order by p_no desc";
	   
	   try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, cno);
		rset = pstmt.executeQuery();
		
		while(rset.next()){
			Post post = new Post();
			post.setpNo(rset.getInt(1));
			post.setpTitle(rset.getString(2));
			post.setpId(rset.getString(3));
			post.setpDate(rset.getDate(4));
			post.setReadCount(rset.getInt(5));
			list.add(post);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
		close(rset);
	}
      return list;
   }

   public ArrayList<Post> selectSearch(Connection conn, String title, int cno) {
	   Statement stmt = null;
	   ResultSet rset = null;
	   ArrayList<Post> list = new ArrayList<Post>();
	   
	   String query = "select p_no, p_title, p_id, p_date, p_readcount "
			   		+ "from post "
			   		+ "where p_code = 2 and p_depth = 1 and c_no = " + cno
			   		+ " and p_title like '%" + title + "%' "
			   		+ "order by p_no desc";
	   try {
		   stmt = conn.createStatement();
		   rset = stmt.executeQuery(query);
		
		while(rset.next()){
			Post post = new Post();
			post.setpNo(rset.getInt(1));
			post.setpTitle(rset.getString(2));
			post.setpId(rset.getString(3));
			post.setpDate(rset.getDate(4));
			post.setReadCount(rset.getInt(5));

			list.add(post);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(stmt);
	}
      return list;
   }

   public Post selectPost(Connection conn, int no) {
      // 게시글 상세 조회
      return null;
   }

   public int insertPost(Connection conn, Post post) {
      // 게시글/댓글 등록
	  int result = 0;
	  PreparedStatement pstmt = null;
	  ResultSet rset = null;
	  
	  String query = "insert into post values(?, 2, ?, ?, 0, sysdate, "
	  		+ "0, ?, ?, ?, ?, 1, 0, ?)";
	  
	  try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, post.getpNo());
		pstmt.setString(2, post.getpTitle());
		pstmt.setString(3, post.getpContent());
		pstmt.setString(4, post.getpPw());
		pstmt.setString(5, post.getOriginalFileName());
		pstmt.setString(6, post.getRenameFileName());
		pstmt.setString(7, post.getpId());
		pstmt.setInt(8, post.getcNo());
		
		result = pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		close(rset);
		close(pstmt);
	}
      return result;
   }

   public int updatePost(Connection conn, Post post) {
      // 게시글/댓글 수정
      return 0;
   }

   public int deletePost(Connection conn, int no, int depth) {
      // 게시글/댓글 삭제
      return 0;
   }

   public int addReadCount(Connection conn, int no) {
      // 게시글 조회수 1 증가
      
      return 0;
   }

	public int getNextNumber(Connection conn, int cno) {
		// 게시물 다음 번호 조회
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int no = 0;
		
		String query = "select max(p_no) from post "
				+ "where p_code = 2 and p_depth = 1 and c_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
				no = rset.getInt(1) + 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
	}
	
}