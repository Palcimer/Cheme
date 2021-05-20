package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	
	public int insertMember(Member m) {// db에 입력입하려고할때
		Connection conn = JDBCTemplate.getConnection();//
		MemberDao dao=new MemberDao();
		
		Member member=dao.SelectMemberUnique(conn,"MEMBER_ID",m.getMemberId());
		if(member!=null)
			return 2;
				
		int result = dao.insertMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int checkId(String id) {// db에 입력입하려고할때
		Connection conn = JDBCTemplate.getConnection();//
		Member member=new MemberDao().SelectMemberUnique(conn, "member_id", id);
		if(member!=null)
			return 0;
		return 1;
		}
	
	public Member selectOneMember(String memberId, String memberPw) {
		//커넥션 생성
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneMember(memberId,memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();

		int result = new MemberDao().updateMember(conn, m);
	
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn, memberNo);

		JDBCTemplate.close(conn);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}



}
