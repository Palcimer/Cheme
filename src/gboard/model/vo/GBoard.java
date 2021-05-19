package gboard.model.vo;

public class GBoard {
	 // 그룹게시글번호 
    private int gBoardNo;
    // 모임번호 
    private int groupId;
    // 그룹게시글제목 
    private String gBoardTitle;
    // 그룹게시글내용 
    private String gBoardContent;
    // 그룹게시글작성자 
    private int gBoardWriter;
    // 그룹게시글게시일 
    private String gBoardDate;
    // 그룹게시글파일명(업로드명) 
    private String gBoardFilename;
    // 그룹게시글파일명(시스템명) 
    private String gBoardFilepath;
    //그룹게시글 작성자 이름
    private String gBoardWriterName;
	public GBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GBoard(int gBoardNo, int groupId, String gBoardTitle, String gBoardContent, int gBoardWriter,
			String gBoardDate, String gBoardFilename, String gBoardFilepath, String gBoardWriterName) {
		super();
		this.gBoardNo = gBoardNo;
		this.groupId = groupId;
		this.gBoardTitle = gBoardTitle;
		this.gBoardContent = gBoardContent;
		this.gBoardWriter = gBoardWriter;
		this.gBoardDate = gBoardDate;
		this.gBoardFilename = gBoardFilename;
		this.gBoardFilepath = gBoardFilepath;
		this.gBoardWriterName = gBoardWriterName;
	}
	public int getgBoardNo() {
		return gBoardNo;
	}
	public void setgBoardNo(int gBoardNo) {
		this.gBoardNo = gBoardNo;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getgBoardTitle() {
		return gBoardTitle;
	}
	public void setgBoardTitle(String gBoardTitle) {
		this.gBoardTitle = gBoardTitle;
	}
	public String getgBoardContent() {
		return gBoardContent;
	}
	public void setgBoardContent(String gBoardContent) {
		this.gBoardContent = gBoardContent;
	}
	public int getgBoardWriter() {
		return gBoardWriter;
	}
	public void setgBoardWriter(int gBoardWriter) {
		this.gBoardWriter = gBoardWriter;
	}
	public String getgBoardDate() {
		return gBoardDate;
	}
	public void setgBoardDate(String gBoardDate) {
		this.gBoardDate = gBoardDate;
	}
	public String getgBoardFilename() {
		return gBoardFilename;
	}
	public void setgBoardFilename(String gBoardFilename) {
		this.gBoardFilename = gBoardFilename;
	}
	public String getgBoardFilepath() {
		return gBoardFilepath;
	}
	public void setgBoardFilepath(String gBoardFilepath) {
		this.gBoardFilepath = gBoardFilepath;
	}
	public String getgBoardWriterName() {
		return gBoardWriterName;
	}
	public void setgBoardWriterName(String gBoardWriterName) {
		this.gBoardWriterName = gBoardWriterName;
	}
	

}
