package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.model.vo.Board;
import board.model.vo.BoardComment;
import common.JDBCTemplate;
import member.model.vo.Member;



public class BoardDao {


	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from board";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectBoardList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String query = "SELECT * FROM (SELECT ROWNUM AS RNUM, N.*FROM (select b.*,member_name from board b join member on ( board_writer = member_no) ORDER BY board_no DESC)N)WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				Board b = new Board();
				Member m = new Member();
				
				b.setFileName(rset.getString("BOARD_FILENAME"));
				b.setFilePath(rset.getString("BOARD_FILEPATH"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setDate(rset.getDate("BOARD_DATE"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardWriter(rset.getInt("BOARD_WRITER"));
				b.setRnum(rset.getInt("rnum"));
				b.setBoardMember(rset.getString("member_name"));
//				b.setBoardMember(rset.getString("m.getMemberId()"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}	
		System.out.println(list.size());
		return list;
	}

	public Board selectOneBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from board where board_no=?";
		Board b = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Board();
				b.setFileName(rset.getString("BOARD_FILENAME"));
				b.setFilePath(rset.getString("BOARD_FILEPATH"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setDate(rset.getDate("BOARD_DATE"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardWriter(rset.getInt("BOARD_WRITER"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	public int insertComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into board_comment values(board_comment_seq.nextval,?,?,1,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bc.getNo());
//			pstmt.setString(2, bc.getCommentWriter());
			pstmt.setString(2, bc.getCommentContent());
			pstmt.setInt(3, bc.getLevel());
			pstmt.setInt(4, bc.getBoardRef());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteBoardComment(Connection conn, int bcNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from board_comment where bc_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bcNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNoticeComment(Connection conn, int bcNo, String bcContent) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board_comment set bc_content=? where bc_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bcContent);
			pstmt.setInt(2, bcNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from board where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board set board_title=?, board_content=?, filename=?,filepath=? where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getFileName());
			pstmt.setString(4, b.getFilePath());
			pstmt.setInt(5, b.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public ArrayList<BoardComment> selectBoardCommentList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardComment> list = new ArrayList<BoardComment>();
		String query = "select * from board_comment where board_ref=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setCommentContent(rset.getString("bc_content"));
				bc.setDate(rset.getDate("bc_date"));
				bc.setLevel(rset.getInt("bc_level"));
				bc.setCommentNo(rset.getInt("bc_no"));
				bc.setBcRef(rset.getInt("bc_ref"));
				bc.setCommentWriter(rset.getString("bc_writer"));
				bc.setBoardRef(rset.getInt("board_ref"));
				list.add(bc); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertBoard(Connection conn, Board b ,Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into board values(board_seq.nextval,?,?,1,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			
			pstmt.setString(3, b.getFileName());
			pstmt.setString(4, b.getFilePath());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println("dao ");
		System.out.println(result);
		return result;
	}


}
