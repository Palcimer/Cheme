package gnotice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import gnotice.model.dao.GNoticeDao;
import gnotice.model.vo.GNotice;
import gnotice.model.vo.GNoticeComment;
import gnotice.model.vo.GNoticeViewData;

public class GNoticeService {

	public ArrayList<GNotice> selectNoticeList(int groupId) {
		Connection conn = JDBCTemplate.getConnection();
		int start = 1;
		int end = 5;
		ArrayList<GNotice> list = new GNoticeDao().selectNoticeList(conn, start, end, groupId);
		JDBCTemplate.close(conn);
		return list;
	}

	public GNoticeViewData selectNoticeData(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		String gName = dao.selectGroupName(conn, noticeNo);
		GNotice notice = dao.selectNotice(conn, noticeNo);
		ArrayList<GNoticeComment> list = dao.selectNoticeCmtList(conn, noticeNo);
		JDBCTemplate.close(conn);
		GNoticeViewData gnvd = new GNoticeViewData(gName, notice, list);
		return gnvd;
	}

	public ArrayList<GNoticeComment> selectNoticeCmtList(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<GNoticeComment> list = new GNoticeDao().selectNoticeCmtList(conn, noticeNo);
		JDBCTemplate.close(conn);
		return list;
	}

	public GNotice selectNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		GNotice notice = dao.selectNotice(conn, noticeNo);
		JDBCTemplate.close(conn);
		return notice;
	}

	public int insertNotice(GNotice notice) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int result = dao.insertNotice(conn, notice);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int result = dao.deleteNotice(conn, noticeNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
