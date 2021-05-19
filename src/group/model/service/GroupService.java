package group.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import group.model.dao.GroupDao;
import group.model.vo.Group;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class GroupService {

	public int insertGroup(Group g) {
				Connection conn = JDBCTemplate.getConnection();
				int result =  new GroupDao().insertGroup(g, conn);
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




}
