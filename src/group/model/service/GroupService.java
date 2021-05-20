package group.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import gnotice.model.dao.GNoticeDao;
import group.model.dao.GroupDao;
import group.model.vo.Group;

public class GroupService {

	public int insertGroup(Group g) {
		// TODO Auto-generated method stub
				Connection conn = JDBCTemplate.getConnection();
				int result = new GroupDao().insertGroup(g, conn);
				if (result > 0) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
				JDBCTemplate.close(conn);
				return result;
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

}
