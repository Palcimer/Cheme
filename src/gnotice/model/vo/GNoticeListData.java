package gnotice.model.vo;

import java.util.ArrayList;

public class GNoticeListData {
	private String groupName;
	private ArrayList<GNotice> list;
	private String pageNavi;
	public GNoticeListData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GNoticeListData(String groupName, ArrayList<GNotice> list, String pageNavi) {
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
	public ArrayList<GNotice> getList() {
		return list;
	}
	public void setList(ArrayList<GNotice> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
