package gnotice.model.vo;

public class GNoticeComment {
	private int gNcNo;
	private int gNcLev;
	private int gNcRef;
	private int gNoticeNo;
	private String gNcWriter;
	private String gNcContent;
	public GNoticeComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GNoticeComment(int gNcNo, int gNcLev, int gNcRef, int gNoticeNo, String gNcWriter, String gNcContent) {
		super();
		this.gNcNo = gNcNo;
		this.gNcLev = gNcLev;
		this.gNcRef = gNcRef;
		this.gNoticeNo = gNoticeNo;
		this.gNcWriter = gNcWriter;
		this.gNcContent = gNcContent;
	}
	public int getgNcNo() {
		return gNcNo;
	}
	public void setgNcNo(int gNcNo) {
		this.gNcNo = gNcNo;
	}
	public int getgNcLev() {
		return gNcLev;
	}
	public void setgNcLev(int gNcLev) {
		this.gNcLev = gNcLev;
	}
	public int getgNcRef() {
		return gNcRef;
	}
	public void setgNcRef(int gNcRef) {
		this.gNcRef = gNcRef;
	}
	public int getgNoticeNo() {
		return gNoticeNo;
	}
	public void setgNoticeNo(int gNoticeNo) {
		this.gNoticeNo = gNoticeNo;
	}
	public String getgNcWriter() {
		return gNcWriter;
	}
	public void setgNcWriter(String gNcWriter) {
		this.gNcWriter = gNcWriter;
	}
	public String getgNcContent() {
		return gNcContent;
	}
	public void setgNcContent(String gNcContent) {
		this.gNcContent = gNcContent;
	}
	
	
}
