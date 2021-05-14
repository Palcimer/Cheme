package gmember.model.vo;

public class GMember {
	private int memberNo;
	private int groupId;
	public GMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GMember(int memberNo, int groupId) {
		super();
		this.memberNo = memberNo;
		this.groupId = groupId;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
}
