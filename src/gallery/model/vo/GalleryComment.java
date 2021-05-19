package gallery.model.vo;

public class GalleryComment {
	private int rnum;
	private int galleryCommentNo;
	private int galleryNo;
	private String galleryCommentContent;
	private int galleryCommentWriter;
	private int galleryCommentLevel;
	private int galleryCommentRef;
	public GalleryComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryComment(int rnum, int galleryCommentNo, int galleryNo, String galleryCommentContent,
			int galleryCommentWriter, int galleryCommentLevel, int galleryCommentRef) {
		super();
		this.rnum = rnum;
		this.galleryCommentNo = galleryCommentNo;
		this.galleryNo = galleryNo;
		this.galleryCommentContent = galleryCommentContent;
		this.galleryCommentWriter = galleryCommentWriter;
		this.galleryCommentLevel = galleryCommentLevel;
		this.galleryCommentRef = galleryCommentRef;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getGalleryCommentNo() {
		return galleryCommentNo;
	}
	public void setGalleryCommentNo(int galleryCommentNo) {
		this.galleryCommentNo = galleryCommentNo;
	}
	public int getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(int galleryNo) {
		this.galleryNo = galleryNo;
	}
	public String getGalleryCommentContentBr() {
		return galleryCommentContent.replaceAll("\r\n","<br>");
	}
	public String getGalleryCommentContent() {
		return galleryCommentContent;
	}
	public void setGalleryCommentContent(String galleryCommentContent) {
		this.galleryCommentContent = galleryCommentContent;
	}
	public int getGalleryCommentWriter() {
		return galleryCommentWriter;
	}
	public void setGalleryCommentWriter(int galleryCommentWriter) {
		this.galleryCommentWriter = galleryCommentWriter;
	}
	public int getGalleryCommentLevel() {
		return galleryCommentLevel;
	}
	public void setGalleryCommentLevel(int galleryCommentLevel) {
		this.galleryCommentLevel = galleryCommentLevel;
	}
	public int getGalleryCommentRef() {
		return galleryCommentRef;
	}
	public void setGalleryCommentRef(int galleryCommentRef) {
		this.galleryCommentRef = galleryCommentRef;
	}
	
	
}
