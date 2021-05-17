package gallery.model.vo;

import java.util.ArrayList;

public class GalleryViewData {
	private Gallery g;
	private ArrayList<GalleryComment> list;
	
	public GalleryViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryViewData(Gallery g, ArrayList<GalleryComment> list) {
		super();
		this.g = g;
		this.list = list;
	}
	public Gallery getG() {
		return g;
	}
	public void setG(Gallery g) {
		this.g = g;
	}
	public ArrayList<GalleryComment> getList() {
		return list;
	}
	public void setList(ArrayList<GalleryComment> list) {
		this.list = list;
	}
	
}
