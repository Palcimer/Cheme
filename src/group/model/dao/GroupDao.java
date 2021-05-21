  
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

   public int modifyGroup(Group g, Connection conn) {
		PreparedStatement pstmt = null;
		String query = "update groups set group_name=?, group_img=? , group_detail=?, max_member=? , keyword1=? ,keyword2=? ,keyword3=? ,keyword4=? ,keyword5=? where group_id=? ";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g.getGroupName());
			pstmt.setString(2, g.getGroupImg());
			pstmt.setString(3, g.getGroupDetail());
			pstmt.setInt(4, g.getMaxMember());
			pstmt.setString(5, g.getKeyword1());
			pstmt.setString(6, g.getKeyword2());
			pstmt.setString(7, g.getKeyword3());
			pstmt.setString(8, g.getKeyword4());
			pstmt.setString(9, g.getKeyword5());
			pstmt.setInt(10, g.getGroupId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}
   
   public boolean isLeader(Connection conn, int groupId, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean isLeader = false;
		String query = "SELECT * FROM GROUPS WHERE GROUP_LEADER=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(rset.getInt("group_id") == groupId) {
					isLeader = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return isLeader;
	}

   public int insertInitMem(int groupId, int groupLeader, Connection conn) {
	   PreparedStatement pstmt = null;
	   int result = 0;
	   String query = "INSERT INTO G_MEMBER VALUES (?, ?)";
	   try {
		   pstmt = conn.prepareStatement(query);
		   pstmt.setInt(1, groupLeader);
		   pstmt.setInt(2, groupId);
		   result = pstmt.executeUpdate();
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   return result;
   }

   public int insertMember(Connection conn, int groupId, int memberNo) {
	   PreparedStatement pstmt = null;
	   int result = 0;
	   String query = "INSERT INTO G_MEMBER VALUES (?, ?)";
	   try {
		   pstmt = conn.prepareStatement(query);
		   pstmt.setInt(1, memberNo);
		   pstmt.setInt(2, groupId);
		   result = pstmt.executeUpdate();
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   return result;
   }

	public int deleteMember(Connection conn, int groupId, int memberNo) {
		PreparedStatement pstmt = null;
		   int result = 0;
		   String query = "DELETE FROM G_MEMBER WHERE MEMBER_NO=? AND GROUP_ID=?";
		   try {
			   pstmt = conn.prepareStatement(query);
			   pstmt.setInt(1, memberNo);
			   pstmt.setInt(2, groupId);
			   result = pstmt.executeUpdate();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		   return result;
	}
   

}