package gallery.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import gallery.model.vo.Gallery;
import gallery.model.vo.GalleryComment;
import group.model.vo.Group;
import member.model.vo.Member;

public class GalleryDao {

	public ArrayList<Gallery> selectGalleryList(Connection conn, int groupId, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		String qeury = "SELECT * FROM (SELECT ROWNUM AS RNUM, N.*FROM (select g.*,member_name from gallery g join member  on (gallery_writer = member_no) where group_id=? ORDER BY GALLERY_NO DESC)N)WHERE RNUM BETWEEN ? AND ?";
		 	
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, groupId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);;
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Gallery g = new Gallery();
				g.setGalleryContent(rset.getString("gallery_content"));
				g.setGalleryDate(rset.getString("gallery_date"));
				g.setGalleryFilepath(rset.getString("gallery_filepath"));
				g.setGalleryNo(rset.getInt("gallery_no"));
				g.setGalleryTitle(rset.getString("gallery_title"));
				g.setGalleryWriter(rset.getInt("gallery_writer"));
				g.setGalleryNickName(rset.getString("member_name"));
				
				g.setGroupId(rset.getInt("group_id"));
				g.setRnum(rset.getInt("rnum"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public int totalCount(Connection conn, int groupId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from gallery where group_id=?";
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
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertGallery(Connection conn, Gallery ga) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into gallery values(gal_seq.nextval,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ga.getGroupId());
			pstmt.setString(2, ga.getGalleryTitle()); 
			pstmt.setString(3, ga.getGalleryContent());
			pstmt.setInt(4, ga.getGalleryWriter());
			pstmt.setString(5, ga.getGalleryFileName());
			pstmt.setString(6, ga.getGalleryFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Gallery selectOneGallery(Connection conn, int galleryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select g.*,member_name from gallery g join member  on (gallery_writer = member_no)  where gallery_no=?";
		Gallery g =null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, galleryNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				g = new Gallery();
				g.setGalleryContent(rset.getString("gallery_content"));
				g.setGalleryDate(rset.getString("gallery_date"));
				g.setGalleryFileName(rset.getString("gallery_filename"));
				g.setGalleryFilepath(rset.getString("gallery_filepath"));
				g.setGalleryNo(rset.getInt("gallery_no"));
				g.setGalleryTitle(rset.getString("gallery_title"));
				g.setGalleryWriter(rset.getInt("gallery_writer"));
				g.setGroupId(rset.getInt("group_id"));
				g.setGalleryNickName(rset.getString("member_name"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return g;
	}

	public ArrayList<GalleryComment> selectGalleryCommentList(Connection conn, int galleryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GalleryComment> list = new ArrayList<GalleryComment>();
		String query = "select g.*,member_name from gal_comment g join member on (member_name = gal_comment_writer) where gal_comment_ref=?;";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, galleryNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				GalleryComment gc = new GalleryComment();
				gc.setGalleryCommentNo(rset.getInt("gal_comment_no"));
				gc.setGalleryNo(rset.getInt("gallery_no"));
				gc.setGalleryCommentContent(rset.getString("gal_comment_content"));
				gc.setGalleryCommentWriter(rset.getInt("gal_comment_writer"));
				gc.setGalleryCommentLevel(rset.getInt("gal_comment_lev"));
				gc.setGalleryCommentRef(rset.getInt("gal_comment_ref"));
				gc.setGalleryName(rset.getString("member_name"));
				list.add(gc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public int updateGalleryComment(Connection conn, String galleryCommentContent, int galleryCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update gal_comment set gal_comment_content=? where gal_comment_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, galleryCommentContent);
			pstmt.setInt(2, galleryCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteGalleryComment(Connection conn, int galleryCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from gal_comment where gal_comment_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, galleryCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteGallery(Connection conn, int galleryNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from gallery where gallery_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, galleryNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int galleryInsertComment(Connection conn, GalleryComment gc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into gal_comment vlaues(gal_comment_seq.nextval,20,?,?,?,?"; //20변경해야함
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gc.getGalleryCommentContentBr());
			pstmt.setInt(2, gc.getGalleryCommentWriter());
			pstmt.setInt(3, gc.getGalleryCommentLevel());
			pstmt.setInt(4, gc.getGalleryCommentRef());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateGallery(Connection conn, Gallery g) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update gallery set gallery_title=? , gallery_content=? , gallery_filename=? , gallery_filepath=? where gallery_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, g.getGalleryTitle());
			pstmt.setString(2, g.getGalleryContent());
			pstmt.setString(3, g.getGalleryFileName());
			pstmt.setString(4, g.getGalleryFilepath());
			pstmt.setInt(5,  g.getGalleryNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Gallery> selectGalListForDetail(Connection conn, int start, int end, int groupId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		String qeury = "SELECT * FROM (SELECT ROWNUM AS RNUM, GNN.* FROM (SELECT ROWNUM AS GALLERY_DESC, GN.* FROM (SELECT * FROM GALLERY WHERE GROUP_ID=? ORDER BY 1) GN ORDER BY 1 DESC) GNN) WHERE RNUM BETWEEN ? AND ?";
		 	
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, groupId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Gallery g = new Gallery();
				g.setGalleryContent(rset.getString("gallery_content"));
				g.setGalleryDate(rset.getString("gallery_date"));
				g.setGalleryFilepath(rset.getString("gallery_filepath"));
				g.setGalleryNo(rset.getInt("gallery_no"));
				g.setGalleryTitle(rset.getString("gallery_title"));
				g.setGalleryWriter(rset.getInt("gallery_writer"));							
				g.setGroupId(rset.getInt("group_id"));
				g.setRnum(rset.getInt("rnum"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

}
