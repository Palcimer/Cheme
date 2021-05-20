package board.model.vo;

import java.sql.Date;

import member.model.vo.Member;

public class Board {
	private int rnum;
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private Date date;
	private String fileName;
	private String filePath;
	private String boardMember;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int rnum, int boardNo, String boardTitle, String boardContent, int boardWriter, Date date,
			String fileName, String filePath, String boardMember) {
		super();
		this.rnum = rnum;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.date = date;
		this.fileName = fileName;
		this.filePath = filePath;
		this.boardMember = boardMember;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(int boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getBoardMember() {
		return boardMember;
	}
	public void setBoardMember(String boardMember) {
		this.boardMember = boardMember;
	}
	
	
}
