package group.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public boolean isMember(Connection conn, int groupId, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		String query = "SELECT * FROM G_MEMBER WHERE MEMBER_NO=? AND GROUP_ID=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, groupId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Group selectOneGroup(Connection conn, int groupId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Group group = new Group();
		String query = "SELECT GROUPS.*, " + 
				"(SELECT CATEGORY_NAME FROM CATEGORY WHERE CATEGORY_NO=(SELECT GROUP_CATEGORY FROM GROUPS WHERE GROUP_ID=?)) AS CATEGORY_NAME, " + 
				"(SELECT MEMBER_NAME FROM MEMBER WHERE MEMBER_NO=(SELECT GROUP_LEADER FROM GROUPS WHERE GROUP_ID=?)) AS LEADER_NAME " + 
				"FROM GROUPS WHERE GROUP_ID=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groupId);
			pstmt.setInt(2, groupId);
			pstmt.setInt(3, groupId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				group.setGroupId(rset.getInt("group_id"));
				group.setCategoryName(rset.getString("category_name"));
				group.setLeaderName(rset.getString("leader_name"));
				group.setGroupName(rset.getString("group_name"));
				group.setGroupDetail(rset.getString("group_detail"));
				group.setGroupImg(rset.getString("group_img"));
				group.setKeyword1(rset.getString("keyword1"));
				group.setKeyword2(rset.getString("keyword2"));
				group.setKeyword3(rset.getString("keyword3"));
				group.setKeyword4(rset.getString("keyword4"));
				group.setKeyword5(rset.getString("keyword5"));
				group.setGroupCategory(rset.getInt("group_category"));
				group.setGroupLeader(rset.getInt("group_leader"));
				group.setMaxMember(rset.getInt("max_member"));
				group.setRecom(rset.getInt("recom"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return group;
	}
}
