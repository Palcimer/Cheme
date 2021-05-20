package gboard.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import gboard.model.dao.GBoardDao;
import gboard.model.vo.GBoard;

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

}
