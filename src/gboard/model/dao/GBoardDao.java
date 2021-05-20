package gboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import gboard.model.vo.GBoard;

public class GBoardDao {

	public int insertBoard(Connection conn, GBoard board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO G_BOARD VALUES(G_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, DEFAULT, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getGroupId());
			pstmt.setString(2, board.getgBoardTitle());
			pstmt.setString(3, board.getgBoardContent());
			pstmt.setInt(4, board.getgBoardWriter());
			pstmt.setString(5, board.getgBoardFilename());
			pstmt.setString(6, board.getgBoardFilepath());
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
