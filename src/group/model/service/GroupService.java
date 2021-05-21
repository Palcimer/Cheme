package group.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import gnotice.model.dao.GNoticeDao;
import group.model.dao.GroupDao;
import group.model.vo.Group;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class GroupService {

	public int insertGroup(Group g) {
				Connection conn = JDBCTemplate.getConnection();
				int result =  new GroupDao().insertGroup(g, conn);
				int result2 = new GroupDao().insertInitMem(g.getGroupId(), g.getGroupLeader(), conn);
				if (result > 0) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
				JDBCTemplate.close(conn);
				return result;
	}

	public ArrayList<Integer> selectGroupId(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Integer> groupIdList  = new GroupDao().selectGroupId(conn, memberNo);
		JDBCTemplate.close(conn);
		return groupIdList;
	}

	public 	ArrayList<Integer> selectGroupLeader(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Integer> leaderNoList = new GroupDao().selectGroupLeader(conn, memberNo);
		JDBCTemplate.close(conn);
		return leaderNoList;
	}

	public ArrayList<Group> selectGroupAsList(ArrayList<Integer> groupIdList) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Group> GroupAsMemberList = new GroupDao().selectGroupAsList(conn, groupIdList);
		JDBCTemplate.close(conn);
		return GroupAsMemberList;
	}




	public boolean isMember(int groupId, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		GroupDao dao = new GroupDao();
		boolean result = dao.isMember(conn, groupId, memberNo);
		JDBCTemplate.close(conn);
		return result;
	}

	public Group selectOneGroup(int groupId) {
		Connection conn = JDBCTemplate.getConnection();
		GroupDao dao = new GroupDao();
		Group group = dao.selectOneGroup(conn, groupId);
		JDBCTemplate.close(conn);
		return group;
	}

	public boolean isLeader(int groupId, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		GroupDao dao = new GroupDao();
		boolean isLeader = dao.isLeader(conn, groupId, memberNo);
		JDBCTemplate.close(conn);
		return isLeader;
	}

	public int modifyGroup(Group g) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GroupDao().modifyGroup(g, conn);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int insertMember(int groupId, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GroupDao().insertMember(conn, groupId, memberNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(int groupId, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GroupDao().deleteMember(conn, groupId, memberNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
