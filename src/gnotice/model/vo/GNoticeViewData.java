package gnotice.model.vo;

import java.util.ArrayList;

public class GNoticeViewData {
	private String groupName;
	private GNotice notice;
	private ArrayList<GNoticeComment> cmtList;
	public GNoticeViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GNoticeViewData(String groupName, GNotice notice, ArrayList<GNoticeComment> cmtList) {
		super();
		this.groupName = groupName;
		this.notice = notice;
		this.cmtList = cmtList;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public GNotice getNotice() {
		return notice;
	}
	public void setNotice(GNotice notice) {
		this.notice = notice;
	}
	public ArrayList<GNoticeComment> getCmtList() {
		return cmtList;
	}
	public void setCmtList(ArrayList<GNoticeComment> cmtList) {
		this.cmtList = cmtList;
	}
	
}
