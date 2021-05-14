package board.model.vo;

import java.sql.Date;

public class Board_comment {
	private int commentNo;
	private int No;
	private String commentContent;
	private int commentWriter;
	private Date date;
	private int level;
	private int commentref;
	public Board_comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board_comment(int commentNo, int no, String commentContent, int commentWriter, Date date, int level,
			int commentref) {
		super();
		this.commentNo = commentNo;
		No = no;
		this.commentContent = commentContent;
		this.commentWriter = commentWriter;
		this.date = date;
		this.level = level;
		this.commentref = commentref;
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
	public int getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(int commentWriter) {
		this.commentWriter = commentWriter;
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
	public int getCommentref() {
		return commentref;
	}
	public void setCommentref(int commentref) {
		this.commentref = commentref;
	}
	
	
}
