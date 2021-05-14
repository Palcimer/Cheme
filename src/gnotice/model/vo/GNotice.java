package gnotice.model.vo;

public class GNotice {
	private int rnum;
	private int gNoticeNo;
	private int groupId;
	private String gNoticeTitle;
	private String gNoticeWriter;
	private String gNoticeContent;
	private String gNoticeDate;
	private String gFilename;
	private String gFilepath;

	public GNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GNotice(int rnum, int noticeNo, String noticeTitle, String noticeContent, int noticeWriter, String noticeDate,
			String noticeFilename, String noticeFilepath) {
		super();
		this.rnum = rnum;
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeFilename = noticeFilename;
		this.noticeFilepath = noticeFilepath;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(int noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeFilename() {
		return noticeFilename;
	}
	public void setNoticeFilename(String noticeFilename) {
		this.noticeFilename = noticeFilename;
	}
	public String getNoticeFilepath() {
		return noticeFilepath;
	}
	public void setNoticeFilepath(String noticeFilepath) {
		this.noticeFilepath = noticeFilepath;
	}
	

}

	public Notice(int rnum, int gNoticeNo, int groupId, String gNoticeTitle, String gNoticeWriter,
			String gNoticeContent, String gNoticeDate, String gFilename, String gFilepath) {
		super();
		this.rnum = rnum;
		this.gNoticeNo = gNoticeNo;
		this.groupId = groupId;
		this.gNoticeTitle = gNoticeTitle;
		this.gNoticeWriter = gNoticeWriter;
		this.gNoticeContent = gNoticeContent;
		this.gNoticeDate = gNoticeDate;
		this.gFilename = gFilename;
		this.gFilepath = gFilepath;
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

	public String getgNoticeWriter() {
		return gNoticeWriter;
	}

	public void setgNoticeWriter(String gNoticeWriter) {
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

	public String getgFilename() {
		return gFilename;
	}

	public void setgFilename(String gFilename) {
		this.gFilename = gFilename;
	}

	public String getgFilepath() {
		return gFilepath;
	}

	public void setgFilepath(String gFilepath) {
		this.gFilepath = gFilepath;
	}
	
}
