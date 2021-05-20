package gallery.model.vo;

public class Gallery {
	
	private String mName;
	private int rnum;
	private int galleryNo;
	private String galleryTitle;
	private int galleryWriter;
	private String galleryContent;
	private String galleryDate;
	private int groupId;
	private String galleryFilepath;
	private String galleryFileName;
	private String galleryNickName;
	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gallery(String mName, int rnum, int galleryNo, String galleryTitle, int galleryWriter, String galleryContent,
			String galleryDate, int groupId, String galleryFilepath, String galleryFileName) {
		super();
		this.mName = mName;
		this.rnum = rnum;
		this.galleryNo = galleryNo;
		this.galleryTitle = galleryTitle;
		this.galleryWriter = galleryWriter;
		this.galleryContent = galleryContent;
		this.galleryDate = galleryDate;
		this.groupId = groupId;
		this.galleryFilepath = galleryFilepath;
		this.galleryFileName = galleryFileName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(int galleryNo) {
		this.galleryNo = galleryNo;
	}
	public String getGalleryTitle() {
		return galleryTitle;
	}
	public void setGalleryTitle(String galleryTitle) {
		this.galleryTitle = galleryTitle;
	}
	public int getGalleryWriter() {
		return galleryWriter;
	}
	public void setGalleryWriter(int galleryWriter) {
		this.galleryWriter = galleryWriter;
	}
	public String getGalleryContentBr() {
		return galleryContent.replaceAll("\r\n", "<br>");
	}
	public String getGalleryContent() {
		return galleryContent;
	}
	public void setGalleryContent(String galleryContent) {
		this.galleryContent = galleryContent;
	}
	public String getGalleryDate() {
		return galleryDate;
	}
	public void setGalleryDate(String galleryDate) {
		this.galleryDate = galleryDate;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGalleryFilepath() {
		return galleryFilepath;
	}
	public void setGalleryFilepath(String galleryFilepath) {
		this.galleryFilepath = galleryFilepath;
	}
	public String getGalleryFileName() {
		return galleryFileName;
	}
	public void setGalleryFileName(String galleryFileName) {
		this.galleryFileName = galleryFileName;
	}
	public String getGalleryNickName() {
		return galleryNickName;
	}
	public void setGalleryNickName(String galleryNickName) {
		this.galleryNickName = galleryNickName;
	}
	
	
}
