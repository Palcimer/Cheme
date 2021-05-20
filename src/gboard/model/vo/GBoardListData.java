package gboard.model.vo;

import java.util.ArrayList;

public class GBoardListData {
	private String groupName;
	private ArrayList<GBoard> list;
	private String pageNavi;
	public GBoardListData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GBoardListData(String groupName, ArrayList<GBoard> list, String pageNavi) {
		super();
		this.groupName = groupName;
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public ArrayList<GBoard> getList() {
		return list;
	}
	public void setList(ArrayList<GBoard> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
