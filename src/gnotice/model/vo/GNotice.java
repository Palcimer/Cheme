package gnotice.model.vo;

public class GNotice {
	private int rnum;
	private int gNoticeNo;
	private int groupId;
	private String gNoticeTitle;
	private int gNoticeWriter;
	private String gNoticeContent;
	private String gNoticeDate;
	private String Filename;
	private String Filepath;
	public GNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GNotice(int rnum, int gNoticeNo, int groupId, String gNoticeTitle, int gNoticeWriter,
			String gNoticeContent, String gNoticeDate, String filename, String filepath) {
		super();
		this.rnum = rnum;
		this.gNoticeNo = gNoticeNo;
		this.groupId = groupId;
		this.gNoticeTitle = gNoticeTitle;
		this.gNoticeWriter = gNoticeWriter;
		this.gNoticeContent = gNoticeContent;
		this.gNoticeDate = gNoticeDate;
		Filename = filename;
		Filepath = filepath;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getgNoticeNo() {
		return gNoticeNo;
	}
	public void setgNoticeNo(int gNoticeNo) {
		this.gNoticeNo = gNoticeNo;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getgNoticeTitle() {
		return gNoticeTitle;
	}
	public void setgNoticeTitle(String gNoticeTitle) {
		this.gNoticeTitle = gNoticeTitle;
	}
	public int getgNoticeWriter() {
		return gNoticeWriter;
	}
	public void setgNoticeWriter(int gNoticeWriter) {
		this.gNoticeWriter = gNoticeWriter;
	}
	public String getgNoticeContent() {
		return gNoticeContent;
	}
	public void setgNoticeContent(String gNoticeContent) {
		this.gNoticeContent = gNoticeContent;
	}
	public String getgNoticeDate() {
		return gNoticeDate;
	}
	public void setgNoticeDate(String gNoticeDate) {
		this.gNoticeDate = gNoticeDate;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
	}
	public String getFilepath() {
		return Filepath;
	}
	public void setFilepath(String filepath) {
		Filepath = filepath;
	}
	
	
}
