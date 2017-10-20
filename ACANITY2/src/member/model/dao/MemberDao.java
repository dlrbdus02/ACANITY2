package member.model.dao;


import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.sql.*;

import member.model.vo.AES128;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberDao {

	public ArrayList<Member> selectList(Connection con) {
		ArrayList<Member> list = null;
	      Statement stmt = null;
	      ResultSet rset = null;
	      
	      String query = "select * from member";
	      
	      try {
	         stmt = con.createStatement();
	         rset = stmt.executeQuery(query);
	         
	         if(rset != null){
	            list = new ArrayList<Member>();
	            while(rset.next()){
	               Member member = new Member();
	               
	               member.setmId(rset.getString("m_id"));
	               member.setmPwd(rset.getString("m_pw"));
	               member.setmName(rset.getString("m_name"));
	               member.setmClass(rset.getString("m_class"));
	               member.setmTime(rset.getString("m_time"));
	               member.setmTel(rset.getString("m_tel"));
	               member.setmEmail(rset.getString("m_email"));
	               
	               
	               list.add(member);
	            }
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally{
	         close(rset);
	         close(stmt);
	      }
	      
	      return list;
	}

	public Member selectMember(Connection con, String memberId, String memberPwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AES128 aes = new AES128("1234567890123456");
		
		String aesPw = aes.encrypt(memberPwd);
		
		
		
		String query = "select * from member where m_id = ? and m_pw = ?";
		
		try{
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, aesPw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				member = new Member();
				
				member.setmId(memberId);
				member.setmPwd(memberPwd);
				member.setmName(rset.getString("m_name"));
				member.setmClass(rset.getString("m_class"));
				member.setmTime(rset.getString("m_time"));
				member.setmTel(rset.getString("m_tel"));
				member.setmEmail(rset.getString("m_email"));
				
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return member;
	}
	
	

	public int insertMember(Connection con, Member member) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		AES128 aes = new AES128("1234567890123456");
		
		String aesPw=aes.encrypt(member.getmPwd());
		
		String query = "insert into member values(?, ?, ?, ?, ?, ?, ?)";
		
		try{
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getmId());
			pstmt.setString(2, aesPw);
			pstmt.setString(3, member.getmName());
			pstmt.setString(7, member.getmClass());
			pstmt.setString(6, member.getmTime());
			pstmt.setString(4, member.getmTel());
			pstmt.setString(5, member.getmEmail());
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
			commit(con);
		}
		
		return result;
	}

	
	/*//아이디 중복 체크 메서드
	public int checkId(Connection con, String userid) throws Exception{
		
		
		PreparedStatement pstmt = null;
		
		int re = 0;
		
		String query = "select * from member where m_id=? ";
		try{
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				re = 1;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(con);
		}
		
		return re;
	}
*/

}
