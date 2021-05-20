package grouplist.model.vo;

import java.util.ArrayList;


import group.model.vo.Group;

public class GroupListPageData {
	private ArrayList<Group> list;
	private String pageNavi;
	public GroupListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupListPageData(ArrayList<Group> list, String pageNavi) {
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
