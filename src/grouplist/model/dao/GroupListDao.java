package grouplist.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import common.JDBCTemplate;
import group.model.vo.Group;

public class GroupListDao {

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from groups";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Group> selectGroupList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Group> list = new ArrayList<Group>();
		String query = "select * from (select rownum as rnum, g.* from (select * from groups order by group_id desc)g) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Group g = new Group();
				g.setGroupId(rset.getInt("GROUP_ID"));
				g.setGroupName(rset.getString("GROUP_NAME"));
				g.setGroupDetail(rset.getString("GROUP_DETAIL"));
				g.setGroupLeader(rset.getInt("GROUP_LEADER"));
				g.setGroupImg(rset.getString("GROUP_IMG"));
				g.setMaxMember(rset.getInt("MAX_MEMBER"));
				g.setGroupCategory(rset.getInt("GROUP_CATEGORY"));
				g.setRecom(rset.getInt("RECOM"));
				g.setKeyword1(rset.getString("KEYWORD1"));
				g.setKeyword2(rset.getString("KEYWORD2"));
				g.setKeyword3(rset.getString("KEYWORD3"));
				g.setKeyword4(rset.getString("KEYWORD4"));
				g.setKeyword5(rset.getString("KEYWORD5"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return list;
	}

	public ArrayList<Group> selectGroupCategory(Connection conn, int groupCategory ,int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Group> list = new ArrayList<Group>();
		String query = "select * from (select rownum as rnum, g.* from ((select * from groups where group_category =?) order by group_id desc)g)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groupCategory);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Group g = new Group();
				g.setGroupId(rset.getInt("GROUP_ID"));
				g.setGroupName(rset.getString("GROUP_NAME"));
				g.setGroupDetail(rset.getString("GROUP_DETAIL"));
				g.setGroupLeader(rset.getInt("GROUP_LEADER"));
				g.setGroupImg(rset.getString("GROUP_IMG"));
				g.setMaxMember(rset.getInt("MAX_MEMBER"));
				g.setGroupCategory(rset.getInt("GROUP_CATEGORY"));
				g.setRecom(rset.getInt("RECOM"));
				g.setKeyword1(rset.getString("KEYWORD1"));
				g.setKeyword2(rset.getString("KEYWORD2"));
				g.setKeyword3(rset.getString("KEYWORD3"));
				g.setKeyword4(rset.getString("KEYWORD4"));
				g.setKeyword5(rset.getString("KEYWORD5"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		
		System.out.println("다오  ");
		System.out.println(groupCategory);
		return list;
	}

	public int groupListViewCount(Connection conn, int groupCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from groups where group_category = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groupCategory);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
