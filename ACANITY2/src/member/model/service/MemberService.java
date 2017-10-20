package member.model.service;

import java.util.ArrayList;
import java.sql.*;
import static common.JDBCTemplate.*;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member loginCheck(String memberId, String memberPwd) {
		Connection con = getConnection();
		Member member = new MemberDao().selectMember(con, memberId, memberPwd);
		close(con);

		return member;
	}

	

	public ArrayList<Member> selectAll() {
		Connection con = getConnection();
		ArrayList<Member> mlist = new MemberDao().selectList(con);
		close(con);
		
		return mlist;
	}




	public int insertMember(Member member) {
		Connection con = getConnection();
		int result = new MemberDao().insertMember(con, member);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);

		return result;
		
	}

}
