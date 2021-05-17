package gnotice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gnotice.model.vo.GNotice;

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
		}
		return gn;
	}

}