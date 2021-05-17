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

	public ArrayList<Gallery> selectGalleryList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		String qeury = "SELECT * FROM (SELECT ROWNUM AS RNUM, N.*FROM (SELECT * FROM GALLERY ORDER BY GALLERY_NO DESC)N)WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);;
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

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from gallery";
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

	public int insertGallery(Connection conn, Gallery ga) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into gallery values(gal_seq.nextval,1000,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, ga.getGalleryTitle()); 
			pstmt.setString(2, ga.getGalleryContent());
			pstmt.setInt(3, ga.getGalleryWriter());
			pstmt.setString(4, ga.getGalleryFileName());
			pstmt.setString(5, ga.getGalleryFilepath());
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
		String query = "select * from gallery where gallery_no=?";
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
				g.setGalleryWriter(rset.getInt("gallery_write"));
				g.setGroupId(rset.getInt("gallery_id"));
				
				
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
		String query = "select * from gallery_comment where notice_ref=?";
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

}
