package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import common.JDBCTemplate;
import notice.model.vo.MainNotice;


public class NoticeDao {

	public ArrayList<MainNotice> selectMainNotice() {
		ArrayList<MainNotice> list = new ArrayList<MainNotice>();
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset  = null;
		String query = "select notice_title,notice_date,notice_no from notice where rownum<=5 order by notice_no desc";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MainNotice n = new MainNotice();
				n.setMainNoticeTitle(rset.getString("notice_title"));
				n.setMainNoticeDate(rset.getString("notice_date"));
				n.setMainNoticeNo(rset.getInt("notice_no"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

}
