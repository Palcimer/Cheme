package board.model.vo;

import java.sql.Date;

public class BoardComment {
	private int commentNo;
	private int No;
	private String commentContent;
	private String commentWriter;
	private Date date;
	private int level;
	private int boardRef;
	private int bcRef;
	
	public BoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardComment(int commentNo, int no, String commentContent, String commentWriter, Date date, int level,
			int boardRef, int bcRef) {
		super();
		this.commentNo = commentNo;
		No = no;
		this.commentContent = commentContent;
		this.commentWriter = commentWriter;
		this.date = date;
		this.level = level;
		this.boardRef = boardRef;
		this.bcRef = bcRef;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String string) {
		this.commentWriter = string;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	public int getBcRef() {
		return bcRef;
	}
	public void setBcRef(int bcRef) {
		this.bcRef = bcRef;
	}
	public String getCommentContentBr() {
		return commentContent.replaceAll("\r\n", "<br>");
	}
	
}
