package group.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
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

}
