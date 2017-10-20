package mypage.model.service;


import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.vo.Community;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import mypage.model.dao.MypageDao;

public class MypageService {

	
	//���� ����Ʈ ��ȸ
	public ArrayList<Community> selectList(){
	      Connection conn = getConnection();
	      ArrayList<Community> list = new MypageDao().selectList(conn);
	      close(conn);      
	      return list;
	   }
	
	//ȸ�� ���� ���� ó���� �޼ҵ�
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

		//ȸ�� Ż�� ó���� �޼ҵ�
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
