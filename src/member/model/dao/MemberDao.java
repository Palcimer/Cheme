package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values(mem_seq.nextval,?,?,?,?,0,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getAddr());			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public Member SelectMemberUnique(Connection conn,String colmn,String value)
	{
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Member member=null;
		String query = "select * from member where "+colmn+"=?";
		try
		{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,value);
			rset=pstmt.executeQuery();
			if(rset.next())
			{
					int memberno=rset.getInt("MEMBER_NO");
					String memberid=rset.getString("MEMBER_ID");
					String memberpw=rset.getString("MEMBER_PW");
					String name=rset.getString("MEMBER_NAME");
					String phone=rset.getString("PHONE");
					int lev=rset.getInt("MEMBER_LEV");
					String gender=rset.getString("GENDER");
					String addr= rset.getString("ADDR");
					member = new Member(memberno,memberid,memberpw,name,phone,lev,gender,addr);
			}
			return member;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return member;
	}

	public Member selectOneMember(String memberId, String memberPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id=? and member_pw=?";
		Member m = null;
		conn= JDBCTemplate.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setPhone(rset.getString("phone"));
				m.setMemberLv(rset.getInt("member_lev"));
				m.setGender(rset.getString("gender"));
				m.setAddr(rset.getString("addr"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = ("update member set member_pw = ?, addr = ?, phone = ?, member_name = ? where member_no = ?");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getAddr());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getMemberName());
			pstmt.setInt(5, m.getMemberNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int deleteMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = ("delete from member where member_no = ?");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);

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