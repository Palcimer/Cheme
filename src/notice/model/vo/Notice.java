package notice.model.vo;

public class Notice {
	private int rnum;
	private int gNoticeNo;
	private int groupId;
	private String gNoticeTitle;
	private String gNoticeWriter;
	private String gNoticeContent;
	private String gNoticeDate;
	private String gFilename;
	private String gFilepath;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
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