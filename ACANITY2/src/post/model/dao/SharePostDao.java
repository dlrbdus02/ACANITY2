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
			   		+ "where p_code = ? and p_depth = ? and c_no = ? "
			   		+ "order by p_no desc";
	   
	   try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, 2);
		pstmt.setInt(2, 1);
		pstmt.setInt(3, cno);
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

   public ArrayList<Post> selectSearch(Connection conn, String title) {
      // 게시글 제목으로 검색 조회
      return null;
   }

   public Post selectPost(Connection conn, int no) {
      // 게시글 상세 조회
      return null;
   }

   public int insertPost(Connection conn, Post post) {
      // 게시글/댓글 등록
      return 0;
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

	public int getMaxNumber(Connection conn, int cno) {
		// 게시물 다음 번호 조회
		Statement stmt = null;
		ResultSet rset = null;
		int no = 0;
		
		String query = "select max(p_no) from post "
				+ "where p_code = 2 and p_depth = 1 and cno = " + cno;
		
		try {
			rset = stmt.executeQuery(query);
			no = rset.getInt(1) + 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
	}
	
}