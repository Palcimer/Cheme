package board.model.vo;

import java.util.ArrayList;

public class BoardViewData {

	private Board b;
	private ArrayList<BoardComment> list;
	public BoardViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardViewData(Board b, ArrayList<BoardComment> list) {
		super();
		this.b = b;
		this.list = list;
	}
	public Board getB() {
		return b;
	}
	public void setB(Board b) {
		this.b = b;
	}
	public ArrayList<BoardComment> getList() {
		return list;
	}
	public void setList(ArrayList<BoardComment> list) {
		this.list = list;
	}
	

}
