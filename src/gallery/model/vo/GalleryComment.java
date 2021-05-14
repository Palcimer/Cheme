package gallery.model.vo;

public class GalleryComment {
	private int rnum;
	private int galleryCommentNo;
	private int galleryNo;
	private String galleryCommentContent;
	private String galleryCommentWriter;
	private String galleryCommentDate;
	private int galleryCommentLevel;
	private int galleryCommentRef;
	public GalleryComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryComment(int rnum, int galleryCommentNo, int galleryNo, String galleryCommentContent,
			String galleryCommentWriter, String galleryCommentDate, int galleryCommentLevel, int galleryCommentRef) {
		super();
		this.rnum = rnum;
		this.galleryCommentNo = galleryCommentNo;
		this.galleryNo = galleryNo;
		this.galleryCommentContent = galleryCommentContent;
		this.galleryCommentWriter = galleryCommentWriter;
		this.galleryCommentDate = galleryCommentDate;
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
	public String getGalleryCommentContent() {
		return galleryCommentContent;
	}
	public void setGalleryCommentContent(String galleryCommentContent) {
		this.galleryCommentContent = galleryCommentContent;
	}
	public String getGalleryCommentWriter() {
		return galleryCommentWriter;
	}
	public void setGalleryCommentWriter(String galleryCommentWriter) {
		this.galleryCommentWriter = galleryCommentWriter;
	}
	public String getGalleryCommentDate() {
		return galleryCommentDate;
	}
	public void setGalleryCommentDate(String galleryCommentDate) {
		this.galleryCommentDate = galleryCommentDate;
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
