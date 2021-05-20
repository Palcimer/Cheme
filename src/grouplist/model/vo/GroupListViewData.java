package grouplist.model.vo;

import java.util.ArrayList;
import group.model.vo.Group;

public class GroupListViewData {
	private ArrayList<Group> list;
	private String pageNavi;
	public GroupListViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupListViewData(ArrayList<Group> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Group> getList() {
		return list;
	}
	public void setList(ArrayList<Group> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
