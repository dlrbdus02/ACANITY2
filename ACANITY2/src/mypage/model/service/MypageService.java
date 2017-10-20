package mypage.model.service;


import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.vo.Community;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import mypage.model.dao.MypageDao;

public class MypageService {

	
	//모임 리스트 조회
	public ArrayList<Community> selectList(){
	      Connection conn = getConnection();
	      ArrayList<Community> list = new MypageDao().selectList(conn);
	      close(conn);      
	      return list;
	   }
	
	//회원 정보 수정 처리용 메소드
		public int updateMember(Member member) {
			Connection con = getConnection();
			int result = new MypageDao().updateMember(con, member);
			
			if(result > 0)
				commit(con);
			else
				rollback(con);
			
			close(con);
			
			return result;
		}

		//회원 탈퇴 처리용 메소드
		public int deleteMember(String userId) {
			Connection con = getConnection();
			int result = new MypageDao().deleteMember(con, userId);
			if(result > 0)
				commit(con);
			else
				rollback(con);
			close(con);
			return result;
		}

		public Member selectMember(String mid) {
			
			Connection con = getConnection();
			Member member = new MypageDao().selectMember(con, mid);
			close(con);
			
			return member;
		}
}
