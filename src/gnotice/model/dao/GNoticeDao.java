package gnotice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import gnotice.model.vo.GNotice;
import gnotice.model.vo.GNoticeComment;

public class GNoticeDao {

	public ArrayList<GNotice> selectNoticeList(Connection conn, int start, int end, int groupId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GNotice> list = new ArrayList<GNotice>();
		String query = "SELECT ROWNUM, GN.* FROM (SELECT * FROM G_NOTICE WHERE GROUP_ID=? ORDER BY 1 DESC) GN WHERE ROWNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groupId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				GNotice gn = new GNotice();
				gn.setFilename(rset.getString("g_notice_filename"));
				gn.setFilepath(rset.getString("g_notice_filepath"));
				gn.setgNoticeContent(rset.getString("g_notice_content"));
				gn.setgNoticeDate(rset.getString("g_notice_date"));
				gn.setgNoticeNo(rset.getInt("g_notice_no"));
				gn.setgNoticeTitle(rset.getString("g_notice_title"));
				gn.setgNoticeWriter(rset.getInt("g_notice_writer"));
				gn.setGroupId(rset.getInt("group_id"));	
				list.add(gn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public GNotice selectNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GNotice gn = new GNotice();
		String query = "SELECT * FROM G_NOTICE WHERE G_NOTICE_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				gn.setFilename(rset.getString("g_notice_filename"));
				gn.setFilepath(rset.getString("g_notice_filepath"));
				gn.setgNoticeContent(rset.getString("g_notice_content"));
				gn.setgNoticeDate(rset.getString("g_notice_date"));
				gn.setgNoticeNo(rset.getInt("g_notice_no"));
				gn.setgNoticeTitle(rset.getString("g_notice_title"));
				gn.setgNoticeWriter(rset.getInt("g_notice_writer"));
				gn.setGroupId(rset.getInt("group_id"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return gn;
	}

	public ArrayList<GNoticeComment> selectNoticeCmtList(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT CMT.*, MEMBER_NAME FROM G_NOTICE_COMMENT CMT JOIN MEMBER ON (G_NOTICE_COMMENT_WRITER = MEMBER_NO) WHERE G_NOTICE_NO=?";
		ArrayList<GNoticeComment> list = new ArrayList<GNoticeComment>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				GNoticeComment cmt = new GNoticeComment();
				cmt.setgNcContent(rset.getString("g_notice_comment_content"));
				cmt.setgNcLev(rset.getInt("g_notice_comment_lev"));
				cmt.setgNcNo(rset.getInt("g_notice_comment_no"));
				cmt.setgNcRef(rset.getInt("g_notice_comment_ref"));
				cmt.setgNcWriterName(rset.getString("member_name"));
				cmt.setgNoticeNo(rset.getInt("g_notice_no"));
				cmt.setgNcDate(rset.getString("g_notice_comment_date"));
				list.add(cmt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return list;
	}

	public String selectGroupName(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String gName = null;
		String query = "SELECT GROUP_NAME FROM GROUPS WHERE GROUP_ID=(SELECT GROUP_ID FROM G_NOTICE WHERE G_NOTICE_NO=?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				gName = rset.getString("group_name");
			}
			System.out.println(gName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return gName;
	}

	public int insertNotice(Connection conn, GNotice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO G_NOTICE VALUES(G_NOTICE_SEQ.NEXTVAL, ?, ?, ?, ?, DEFAULT, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, notice.getGroupId());
			pstmt.setString(2, notice.getgNoticeTitle());
			pstmt.setString(3, notice.getgNoticeContent());
			pstmt.setInt(4, notice.getgNoticeWriter());
			pstmt.setString(5, notice.getFilename());
			pstmt.setString(6, notice.getFilepath());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM G_NOTICE WHERE G_NOTICE_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, GNotice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE G_NOTICE SET G_NOTICE_TITLE=?, G_NOTICE_CONTENT=?, G_NOTICE_FILENAME=?, G_NOTICE_FILEPATH=? WHERE G_NOTICE_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getgNoticeTitle());
			pstmt.setString(2, notice.getgNoticeContent());
			pstmt.setString(3, notice.getFilename());
			pstmt.setString(4, notice.getFilepath());
			pstmt.setInt(5, notice.getgNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertNoticeCmt(Connection conn, GNoticeComment cmt) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO G_NOTICE_COMMENT VALUES(G_NOTICE_COMMENT_SEQ.NEXTVAL, ?, ?, ?, ?, NULL, DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cmt.getgNoticeNo());
			pstmt.setString(2, cmt.getgNcContent());
			pstmt.setInt(3, cmt.getgNcWriter());
			pstmt.setInt(4, cmt.getgNcLev());
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