package gallery.model.vo;

public class Gallery {
	private int rnum;
	private int galleryNo;
	private String galleryTitle;
	private String galleryWriter;
	private String galleryContent;
	private String galleryDate;
	private String groupId;
	private String galleryFilepath;
	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gallery(int rnum, int galleryNo, String galleryTitle, String galleryWriter, String galleryContent,
			String galleryDate, String groupId, String galleryFilepath) {
		super();
		this.rnum = rnum;
		this.galleryNo = galleryNo;
		this.galleryTitle = galleryTitle;
		this.galleryWriter = galleryWriter;
		this.galleryContent = galleryContent;
		this.galleryDate = galleryDate;
		this.groupId = groupId;
		this.galleryFilepath = galleryFilepath;
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
	public String getGalleryWriter() {
		return galleryWriter;
	}
	public void setGalleryWriter(String galleryWriter) {
		this.galleryWriter = galleryWriter;
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
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGalleryFilepath() {
		return galleryFilepath;
	}
	public void setGalleryFilepath(String galleryFilepath) {
		this.galleryFilepath = galleryFilepath;
	}
	
	
}
