package board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWrite;
	private Date date;
	private String fileName;
	private String filePath;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String boardTitle, String boardContent, int boardWrite, Date date, String fileName,
			String filePath) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWrite = boardWrite;
		this.date = date;
		this.fileName = fileName;
		this.filePath = filePath;
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
	public int getBoardWrite() {
		return boardWrite;
	}
	public void setBoardWrite(int boardWrite) {
		this.boardWrite = boardWrite;
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
	
	
}
