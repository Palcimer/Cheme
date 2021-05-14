package group.model.vo;

public class Group {
	 // 모임번호 
    private int groupId;
    // 모임이름 
    private String groupName;
    // 모임소개 
    private String groupDetail;
    // 모임장 
    private int groupLeader;
    // 대표이미지 
    private String groupImg;
    // 설정인원 
    private int maxMember;
    // 카테고리 
    private int groupCategory;
    // 추천수 
    private int recom;
    // 키워드1 
    private String keyword1;
    // 키워드2 
    private String keyword2;
    // 키워드3 
    private String keyword3;
    // 키워드4 
    private String keyword4;
    // 키워드5 
    private String keyword5;
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(int groupId, String groupName, String groupDetail, int groupLeader, String groupImg, int maxMember,
			int groupCategory, int recom, String keyword1, String keyword2, String keyword3, String keyword4,
			String keyword5) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDetail = groupDetail;
		this.groupLeader = groupLeader;
		this.groupImg = groupImg;
		this.maxMember = maxMember;
		this.groupCategory = groupCategory;
		this.recom = recom;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		this.keyword5 = keyword5;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDetail() {
		return groupDetail;
	}
	public void setGroupDetail(String groupDetail) {
		this.groupDetail = groupDetail;
	}
	public int getGroupLeader() {
		return groupLeader;
	}
	public void setGroupLeader(int groupLeader) {
		this.groupLeader = groupLeader;
	}
	public String getGroupImg() {
		return groupImg;
	}
	public void setGroupImg(String groupImg) {
		this.groupImg = groupImg;
	}
	public int getMaxMember() {
		return maxMember;
	}
	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}
	public int getGroupCategory() {
		return groupCategory;
	}
	public void setGroupCategory(int groupCategory) {
		this.groupCategory = groupCategory;
	}
	public String getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	public String getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}
	public String getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}
	public String getKeyword4() {
		return keyword4;
	}
	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}
	public String getKeyword5() {
		return keyword5;
	}
	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}
	public int getRecom() {
		return recom;
	}
	public void setRecom(int recom) {
		this.recom = recom;
	}
}
