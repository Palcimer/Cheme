package gallery.model.vo;

import java.util.ArrayList;

public class GalleryPageData {
	private ArrayList<Gallery> list;
	private String pageNavi;
	
	public GalleryPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryPageData(ArrayList<Gallery> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Gallery> getList() {
		return list;
	}
	public void setList(ArrayList<Gallery> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
