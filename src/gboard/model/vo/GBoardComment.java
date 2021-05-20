package gboard.model.vo;

public class GBoardComment {
	// 그룹게시판댓글번호 
    private int gBoardCommentNo;
    // 그룹게시글번호 
    private int gBoardNo;
    // 그룹게시판댓글내용 
    private String gBoardCommentContent;
    // 그룹게시판댓글작성자 
    private int gBoardCommentWriter;
    // 그룹게시판댓글게시일 
    private String gBoardCommentDate;
    // 그룹게시판댓글레벨 
    private int gBoardCommentLev;
    // 그룹게시판댓글구분 
    private int gBoardCommentRef;
    // 댓글작성자이름
    private String gBoardCommentWriterName;
	public GBoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GBoardComment(int gBoardCommentNo, int gBoardNo, String gBoardCommentContent, int gBoardCommentWriter,
			String gBoardCommentDate, int gBoardCommentLev, int gBoardCommentRef, String gBoardCommentWriterName) {
		super();
		this.gBoardCommentNo = gBoardCommentNo;
		this.gBoardNo = gBoardNo;
		this.gBoardCommentContent = gBoardCommentContent;
		this.gBoardCommentWriter = gBoardCommentWriter;
		this.gBoardCommentDate = gBoardCommentDate;
		this.gBoardCommentLev = gBoardCommentLev;
		this.gBoardCommentRef = gBoardCommentRef;
		this.gBoardCommentWriterName = gBoardCommentWriterName;
	}
	public int getgBoardCommentNo() {
		return gBoardCommentNo;
	}
	public void setgBoardCommentNo(int gBoardCommentNo) {
		this.gBoardCommentNo = gBoardCommentNo;
	}
	public int getgBoardNo() {
		return gBoardNo;
	}
	public void setgBoardNo(int gBoardNo) {
		this.gBoardNo = gBoardNo;
	}
	public String getgBoardCommentContent() {
		return gBoardCommentContent;
	}
	public String getgBoardCommentContentBr() {
		return gBoardCommentContent.replaceAll("\r\n", "<br>");
	}
	public void setgBoardCommentContent(String gBoardCommentContent) {
		this.gBoardCommentContent = gBoardCommentContent;
	}
	public int getgBoardCommentWriter() {
		return gBoardCommentWriter;
	}
	public void setgBoardCommentWriter(int gBoardCommentWriter) {
		this.gBoardCommentWriter = gBoardCommentWriter;
	}
	public String getgBoardCommentDate() {
		return gBoardCommentDate;
	}
	public void setgBoardCommentDate(String gBoardCommentDate) {
		this.gBoardCommentDate = gBoardCommentDate;
	}
	public int getgBoardCommentLev() {
		return gBoardCommentLev;
	}
	public void setgBoardCommentLev(int gBoardCommentLev) {
		this.gBoardCommentLev = gBoardCommentLev;
	}
	public int getgBoardCommentRef() {
		return gBoardCommentRef;
	}
	public void setgBoardCommentRef(int gBoardCommentRef) {
		this.gBoardCommentRef = gBoardCommentRef;
	}
	public String getgBoardCommentWriterName() {
		return gBoardCommentWriterName;
	}
	public void setgBoardCommentWriterName(String gBoardCommentWriterName) {
		this.gBoardCommentWriterName = gBoardCommentWriterName;
	}
    
}
