package gnotice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import gnotice.model.dao.GNoticeDao;
import gnotice.model.vo.GNotice;
import gnotice.model.vo.GNoticeComment;
import gnotice.model.vo.GNoticeListData;
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
		String gName = dao.selectGroupNameByNoticeNo(conn, noticeNo);
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

	public int updateGNotice(GNotice notice) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int result = dao.updateNotice(conn, notice);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int insertNoticeCmt(GNoticeComment cmt) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int result = dao.insertNoticeCmt(conn, cmt);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public boolean isMember(int groupId, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		boolean result = dao.isMember(conn, groupId, memberNo);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNoticeCmt(int cmtNo) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int result = dao.deleteNoticeCmt(conn, cmtNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int updateNoticeCmt(int cmtNo, String gNcContent) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int result = dao.updateNoticeCmt(conn, cmtNo, gNcContent);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public GNoticeListData selectGNoticeList(int groupId, int page) {
		Connection conn = JDBCTemplate.getConnection();
		GNoticeDao dao = new GNoticeDao();
		int numPerPage = 8;
		int end = page * numPerPage;
		int start = end - numPerPage + 1;
		String groupName = dao.selectGroupNameByGroupId(conn, groupId);
		ArrayList<GNotice> list = dao.selectNoticeList(conn, start, end, groupId);
		
		//페이지 내비게이션
		int totalNotice = dao.totalNotice(conn, groupId); //전체 공지 게시물 수
		int totalPage = 0; //전체 페이지 수 변수
		if(totalNotice % numPerPage == 0) { //게시물 수가 numPerPage 단위로 끝어질 때
			totalPage = totalNotice/numPerPage;
		} else { //그 외의 경우
			totalPage = totalNotice/numPerPage + 1;
		}		
		int pageNaviSize = 5; //페이지 내비게이션에 보여줄 페이지 수
		String pageNavi = "<ul class='pagination pagination-sm justify-content-center' style='margin:0 auto;'>"; //페이지 내비게이션 태그 스트링
		//페이지 내비게이션의 시작 페이지 번호 구하기: 1에서 5 페이지 요청 시 페이지 내비 시작번호는 1, 6~10 페이지 요청 시 시작번호 6, ....
		int pageNo = ((page - 1)/pageNaviSize) * pageNaviSize + 1;
		//이전 버튼
		if(pageNo != 1) { //페이지 내비 시작 페이지번호가 1이 아닌 경우
			pageNavi += "<li class='page-item'>";			
			pageNavi += "<a class='page-link' href='/gNoticeList?groupId=" + groupId + "&page=" + (pageNo - 1) + "'>&laquo;</a></li>";
		} else { //페이지 내비 시작 페이지번호가 1인 경우
			pageNavi += "<li class='page-item disabled'>";			
			pageNavi += "<a class='page-link' href='/gNoticeList?groupId=" + groupId + "&page=" + (pageNo - 1) + "'>&laquo;</a></li>";
		}
		//페이지 숫자
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == page) { //현재 페이지 표시
				pageNavi += "<li class='page-item active'>";
				pageNavi += "<a class='page-link' href='/gNoticeList?groupId=" + groupId + "&page=" + pageNo + "'>" + pageNo + "</a></li>";
			} else { //그 외 페이지 표시
				pageNavi += "<li class='page-item'>";
				pageNavi += "<a class='page-link' href='/gNoticeList?groupId=" + groupId + "&page=" + pageNo + "'>" + pageNo + "</a></li>";
			}
			pageNo++; //페이지 번호 증가
			//없는 페이지 출력하지 않게하는 코드
			//pageNo가 6에서 시작했을 경우, for문을 돌며 하나씩 내비에 표시해주다가 pageNo가 총 페이지수를 넘기는 순간 for문 종료
			if(pageNo > totalPage) { 
				break;
			}
		}
		//다음 버튼
		if(pageNo <= totalPage) { //pageNo가 총 페이지수보다 작을 때만 다음 버튼 표시
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/gNoticeList?groupId=" + groupId + "&page=" + (pageNo) + "'>&raquo;</a></li>";
		} else {
			pageNavi += "<li class='page-item disabled'>";
			pageNavi += "<a class='page-link' href='/gNoticeList?groupId=" + groupId + "&page=" + (pageNo) + "'>&raquo;</a></li>";
		}
		pageNavi += "</ul>";
		

		JDBCTemplate.close(conn);
		GNoticeListData data = new GNoticeListData(groupName, list, pageNavi);
		return data;
	}

}
