package mypage.model.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import community.model.vo.Community;
import member.model.vo.Member;

public class MypageDao {
	
	public MypageDao(){}

	  // 게시글 리스트 조회
	public ArrayList<Community> selectList(Connection conn) {
	     
	      return null;
	   }
	
	
	//회원 정보 수정
	public int updateMember(Connection con, Member member){
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member set m_name = ? m_tel = ? m_email = ? where m_id = ?";
		
		try{
			
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1, member.getmPwd());
			pstmt.setString(1, member.getmName());
			pstmt.setString(2, member.getmTel());
			pstmt.setString(3, member.getmEmail());
			pstmt.setString(4, member.getmId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	
	
	//회원 탈퇴 
	public int deleteMember(Connection con, String userId) {
		
		return 0;
	}

	public Member selectMember(Connection con, String mid) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where m_id = ?";
		
		try{
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				member = new Member();
				
				member.setmId(mid);
				member.setmPwd(rset.getString("m_pw"));
				member.setmName(rset.getString("m_name"));
				member.setmTel(rset.getString("m_tel"));
				member.setmEmail(rset.getString("m_email"));
				member.setmTime(rset.getString("m_time"));
				member.setmClass(rset.getString("m_class"));
							
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return member;
		
	}
}
