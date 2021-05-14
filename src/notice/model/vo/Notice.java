package notice.model.vo;

public class Notice {
	private int rnum;
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private int noticeWriter;
	private String noticeDate;
	private String noticeFilename;
	private String noticeFilepath;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int rnum, int noticeNo, String noticeTitle, String noticeContent, int noticeWriter, String noticeDate,
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
