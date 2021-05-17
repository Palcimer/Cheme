package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardComment;
import board.model.vo.BoardPageData;
import board.model.vo.BoardViewData;
import common.JDBCTemplate;









public class BoardService {

	public BoardPageData selectBoardList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//1. 한페이지에 게시물을 몇개 보여줄지  : 한페이지당 10개씩 보여줌
		int numPerPage = 10;
		//reqPage를 통해서 게시물 시작 rnum 끝 rnum 계산
		//1 -> start : 1, end : 10, 2-> start : 11, end : 20, 3 -> start : 21, end : 30
		int end = reqPage*numPerPage;
		int start = end - numPerPage + 1;
		//요청한 페이지의 게시물을 조회
		BoardDao dao = new BoardDao();
		ArrayList<Board> list = dao.selectBoardList(conn,start,end);
		//페이지 네비게이션제작
		//1) 전체 페이지수를 구해야함 85/10
		//전체 게시물 수 조회          
		int totalCount = dao.totalCount(conn);
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		//페이지 네비 길이지정
		int pageNaviSize = 5;
		//1~5페이지 요청시 페이지 네비 시작번호 : 1
		//6~10페이지 요청하면 페이 네비 시작번호 : 6
		//11 15페이지 요청하면 페이지네비 시작번호 : 11
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		//페이지네비 시작
		String pageNavi = "<ul  class='pagination pagination-lg justify-content-center'>";
		//페이지 네비 시작번호가 1이 아닌경우는 이전버튼 생성
		if(pageNo != 1) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/board?reqPage="+(pageNo-1)+"'>&lt;</a></li>";
		}
		//페이지 숫자 생성
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li class='page-item active'>";
				pageNavi += "<a class='page-link' href='/board?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}else {
				pageNavi += "<li class='page-item'>";
				pageNavi += "<a class='page-link' href='/board?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;
			}
		}
		//다음버튼 생성
		if(pageNo <= totalPage) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/board?reqPage="+(pageNo)+"'>&gt;</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		BoardPageData bpd = new BoardPageData(list, pageNavi);
 		return bpd;
		
	}

	

	public Board selectOneBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		BoardDao dao = new BoardDao();
		Board b = dao.selectOneBoard(conn,boardNo);		
		JDBCTemplate.close(conn);
		return b;
	}



	public int insertComment(BoardComment bc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().insertComment(conn,bc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public int deleteBoardComment(int bcNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().deleteBoardComment(conn,bcNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public int updateBoardComment(int bcNo, String bcContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().updateNoticeComment(conn,bcNo,bcContent);
		if(result>0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public int deleteBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().deleteBoard(conn,boardNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public int updateBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().updateNotice(conn,b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public BoardViewData selectBoardView(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		BoardDao dao = new BoardDao();
		Board b = dao.selectOneBoard(conn,boardNo);
		ArrayList<BoardComment> list = dao.selectBoardCommentList(conn,boardNo);
		JDBCTemplate.close(conn);
		BoardViewData bvd = new BoardViewData(b, list);
		return bvd;
	}



	public int insertBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().insertBoard(conn,b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	

}
