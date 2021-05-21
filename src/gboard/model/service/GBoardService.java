package gboard.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import gboard.model.dao.GBoardDao;
import gboard.model.vo.GBoard;
import gboard.model.vo.GBoardComment;
import gboard.model.vo.GBoardListData;
import gboard.model.vo.GBoardViewData;
import gnotice.model.dao.GNoticeDao;

public class GBoardService {

	public int insertBoard(GBoard board) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int result = dao.insertBoard(conn, board);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public GBoardListData selectGBoardList(int groupId, int page) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int numPerPage = 8;
		int end = page * numPerPage;
		int start = end - numPerPage + 1;
		String groupName = new GNoticeDao().selectGroupNameByGroupId(conn, groupId);
		ArrayList<GBoard> list = dao.selectBoardList(conn, start, end, groupId);
		
		int totalNotice = dao.totalBoard(conn, groupId);
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
				pageNavi += "<a class='page-link' href='/gBoardList?groupId=" + groupId + "&page=" + pageNo + "'>" + pageNo + "</a></li>";
			} else { //그 외 페이지 표시
				pageNavi += "<li class='page-item'>";
				pageNavi += "<a class='page-link' href='/gBoardList?groupId=" + groupId + "&page=" + pageNo + "'>" + pageNo + "</a></li>";
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
			pageNavi += "<a class='page-link' href='/gBoardList?groupId=" + groupId + "&page=" + (pageNo) + "'>&raquo;</a></li>";
		} else {
			pageNavi += "<li class='page-item disabled'>";
			pageNavi += "<a class='page-link' href='/gBoardList?groupId=" + groupId + "&page=" + (pageNo) + "'>&raquo;</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		GBoardListData pageData = new GBoardListData(groupName, list, pageNavi);
		
		return pageData;
	}

	public GBoardViewData selectBoardData(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		String gName = dao.selectGroupNameByBoardNo(conn, boardNo);
		GBoard board = dao.selectBoard(conn, boardNo);
		ArrayList<GBoardComment> list = dao.selectBoardCmtList(conn, boardNo);
		JDBCTemplate.close(conn);
		GBoardViewData data = new GBoardViewData(gName, board, list);
		return data;
	}

	public int deleteBoardCmt(int cmtNo) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int result = dao.deleteBoardCmt(conn, cmtNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int updateBoardCmt(int cmtNo, String gNcContent) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int result = dao.updateBoardCmt(conn, cmtNo, gNcContent);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int insertBoardCmt(GBoardComment cmt) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int result = dao.insertBoardCmt(conn, cmt);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public GBoard selectBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		GBoard board = dao.selectBoard(conn, boardNo);
		JDBCTemplate.close(conn);
		return board;
	}

	public int deleteBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int result = dao.deleteBoard(conn, boardNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int updateGBoard(GBoard board) {
		Connection conn = JDBCTemplate.getConnection();
		GBoardDao dao = new GBoardDao();
		int result = dao.updateBoard(conn, board);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ArrayList<GBoard> selectGBoardList(int groupId) {
		Connection conn = JDBCTemplate.getConnection();
		int start = 1;
		int end = 5;
		ArrayList<GBoard> list = new GBoardDao().selectBoardList(conn, start, end, groupId);
		JDBCTemplate.close(conn);
		return list;
	}

}
