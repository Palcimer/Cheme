package gallery.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import gallery.model.vo.Gallery;

public class GalleryDao {

	public ArrayList<Gallery> selectGalleryList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		String qeury = "SELECT * FROM (SELECT ROWNUM AS RNUM, N.*FROM (SELECT * FROM NOTICE ORDER BY NOTICE_NO DESC)N)WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);;
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Gallery g = new Gallery();
				g.setGalleryContent(rset.getString("gallerycontent"));
				g.setGalleryDate(rset.getString("gallerydate"));
				g.setGalleryFilepath(rset.getString("galleryfilepath"));
				g.setGalleryNo(rset.getInt("galleryno"));
				g.setGalleryTitle(rset.getString("gallerytitle"));
				g.setGalleryWriter(rset.getInt("gallerywriter"));
				g.setGroupId(rset.getString("groupid"));
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

}
