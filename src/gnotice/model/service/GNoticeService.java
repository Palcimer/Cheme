package gnotice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import gnotice.model.dao.GNoticeDao;
import gnotice.model.vo.GNotice;

public class GNoticeService {

	public ArrayList<GNotice> selectNoticeList(int groupId) {
		Connection conn = JDBCTemplate.getConnection();
		int start = 1;
		int end = 5;
		ArrayList<GNotice> list = new GNoticeDao().selectNoticeList(conn, start, end, groupId);
		JDBCTemplate.close(conn);
		return list;
	}

	public GNotice selectNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		GNotice notice = new GNoticeDao().selectNotice(conn, noticeNo);
		JDBCTemplate.close(conn);
		return notice;
	}

}
