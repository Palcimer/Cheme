package gboard.model.vo;

import java.util.ArrayList;

public class GBoardViewData {
	private String groupName;
	private GBoard board;
	private ArrayList<GBoardComment> cmtList;
	public GBoardViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GBoardViewData(String groupName, GBoard board, ArrayList<GBoardComment> cmtList) {
		super();
		this.groupName = groupName;
		this.board = board;
		this.cmtList = cmtList;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public GBoard getBoard() {
		return board;
	}
	public void setBoard(GBoard board) {
		this.board = board;
	}
	public ArrayList<GBoardComment> getCmtList() {
		return cmtList;
	}
	public void setCmtList(ArrayList<GBoardComment> cmtList) {
		this.cmtList = cmtList;
	}
	
}
