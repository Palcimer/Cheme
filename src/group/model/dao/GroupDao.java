package group.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import group.model.vo.Group;

public class GroupDao {
	public int insertGroup(Group g, Connection conn) {

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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public ArrayList<Integer> selectGroupId(Connection conn, int memberNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from g_member where member_no = ?";
		ArrayList<Integer> groupIdList = new ArrayList<Integer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				int groupId = (rset.getInt("group_id"));
				groupIdList.add(groupId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return groupIdList;
	}

	public ArrayList<Integer> selectGroupLeader(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from groups where group_leader = ?";
		ArrayList<Integer> leaderNoList = new ArrayList<Integer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				int groupId = (rset.getInt("group_id"));
				leaderNoList.add(groupId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return leaderNoList;
	}

	public ArrayList<Group> selectGroupAsList(Connection conn, ArrayList<Integer> groupIdList) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from groups where group_id = ?";
		ArrayList<Group> GroupAsMemberList = new ArrayList<Group>();
		try {
			for (int i : groupIdList) {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, i);
				rset = pstmt.executeQuery();

				if (rset.next()) {
					Group g = new Group();

					g.setGroupId((rset.getInt("group_id")));
					g.setGroupName((rset.getString("group_name")));
					g.setGroupImg((rset.getString("group_img")));
					g.setKeyword1((rset.getString("keyword1")));
					g.setKeyword2((rset.getString("keyword2")));
					g.setKeyword3((rset.getString("keyword3")));
					g.setKeyword4((rset.getString("keyword4")));
					g.setKeyword5((rset.getString("keyword5")));
					g.setRecom(rset.getInt("recom"));
					GroupAsMemberList.add(g);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return GroupAsMemberList;
	}

}
