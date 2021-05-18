package notice.model.vo;

public class MainNotice {
	private int mainNoticeNo;
	private String mainNoticeTitle;
	private String mainNoticeDate;
	public MainNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainNotice(int mainNoticeNo, String mainNoticeTitle, String mainNoticeDate) {
		super();
		this.mainNoticeNo = mainNoticeNo;
		this.mainNoticeTitle = mainNoticeTitle;
		this.mainNoticeDate = mainNoticeDate;
	}
	public int getMainNoticeNo() {
		return mainNoticeNo;
	}
	public void setMainNoticeNo(int mainNoticeNo) {
		this.mainNoticeNo = mainNoticeNo;
	}
	public String getMainNoticeTitle() {
		return mainNoticeTitle;
	}
	public void setMainNoticeTitle(String mainNoticeTitle) {
		this.mainNoticeTitle = mainNoticeTitle;
	}
	public String getMainNoticeDate() {
		return mainNoticeDate;
	}
	public void setMainNoticeDate(String mainNoticeDate) {
		this.mainNoticeDate = mainNoticeDate;
	}
	
}
