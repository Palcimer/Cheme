package group.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import group.model.vo.Group;

public class GroupDao {
	public int insertGroup(Group g,Connection conn) {

		PreparedStatement pstmt = null;
		String query = "insert into groups values(group_seq.nextval,?,?,?,?,?,?,0,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g.getGroupName());
			pstmt.setString(2, g.getGroupDetail());
			pstmt.setInt(3, g.getGroupLeader());
			pstmt.setString(4, g.getGroupImg());
			pstmt.setInt(5, g.getMaxMember());
			pstmt.setInt(6, g.getGroupCategory());
			pstmt.setString(7, g.getKeyword1());
			pstmt.setString(8, g.getKeyword2());
			pstmt.setString(9, g.getKeyword3());
			pstmt.setString(10, g.getKeyword4());
			pstmt.setString(11, g.getKeyword5());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}
}
