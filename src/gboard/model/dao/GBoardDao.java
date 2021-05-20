package gboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import gboard.model.vo.GBoard;
import gboard.model.vo.GBoardComment;

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

	public ArrayList<GBoard> selectBoardList(Connection conn, int start, int end, int groupId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GBoard> list = new ArrayList<GBoard>();
		String query = "SELECT ROWNUM, GNN.* FROM (SELECT ROWNUM AS G_BOARD_NO_DESC, GN.* FROM (SELECT G.*, MEMBER_NAME FROM G_BOARD G JOIN MEMBER ON (G_BOARD_WRITER=MEMBER_NO) WHERE GROUP_ID=? ORDER BY 1) GN ORDER BY 1 DESC) GNN WHERE ROWNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groupId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				GBoard gb = new GBoard();
				gb.setgBoardContent(rset.getString("g_board_content"));
				gb.setgBoardDate(rset.getString("g_board_date"));
				gb.setgBoardFilename(rset.getString("g_board_filename"));
				gb.setgBoardFilepath(rset.getString("g_board_filepath"));
				gb.setgBoardTitle(rset.getString("g_board_title"));
				gb.setgBoardWriterName(rset.getString("member_name"));
				gb.setgBoardNo(rset.getInt("g_board_no"));
				gb.setgBoardWriter(rset.getInt("g_board_writer"));
				gb.setGroupId(rset.getInt("group_id"));
				gb.setRnum(rset.getInt("g_board_no_desc"));
				list.add(gb);
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

	public int totalBoard(Connection conn, int groupId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS CNT FROM G_BOARD WHERE GROUP_ID=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, groupId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String selectGroupNameByBoardNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String gName = null;
		String query = "SELECT GROUP_NAME FROM GROUPS WHERE GROUP_ID=(SELECT GROUP_ID FROM G_BOARD WHERE G_BOARD_NO=?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
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

	public GBoard selectBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GBoard gb = new GBoard();
		String query = "SELECT G.*, MEMBER_NAME FROM G_BOARD G JOIN MEMBER ON (G_BOARD_WRITER=MEMBER_NO) WHERE G_BOARD_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				gb.setgBoardContent(rset.getString("g_board_content"));
				gb.setgBoardDate(rset.getString("g_board_date"));
				gb.setgBoardFilename(rset.getString("g_board_filename"));
				gb.setgBoardFilepath(rset.getString("g_board_filepath"));
				gb.setgBoardTitle(rset.getString("g_board_title"));
				gb.setgBoardWriterName(rset.getString("member_name"));
				gb.setgBoardNo(rset.getInt("g_board_no"));
				gb.setgBoardWriter(rset.getInt("g_board_writer"));
				gb.setGroupId(rset.getInt("group_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gb;
	}

	public ArrayList<GBoardComment> selectBoardCmtList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GBoardComment> list = new ArrayList<GBoardComment>();
		String query = "SELECT CMT.*, MEMBER_NAME FROM G_BOARD_COMMENT CMT JOIN MEMBER ON (G_BOARD_COMMENT_WRITER = MEMBER_NO) WHERE G_BOARD_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				GBoardComment cmt = new GBoardComment();
				cmt.setgBoardCommentContent(rset.getString("g_board_comment_content"));
				cmt.setgBoardCommentDate(rset.getString("g_board_comment_date"));
				cmt.setgBoardCommentWriterName(rset.getString("member_name"));
				cmt.setgBoardCommentLev(rset.getInt("g_board_comment_lev"));
				cmt.setgBoardCommentNo(rset.getInt("g_board_comment_no"));
				cmt.setgBoardCommentRef(rset.getInt("g_board_comment_ref"));
				cmt.setgBoardCommentWriter(rset.getInt("g_board_comment_writer"));
				cmt.setgBoardNo(rset.getInt("g_board_no"));
				list.add(cmt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}

}
