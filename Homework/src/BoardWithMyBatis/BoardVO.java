package BoardWithMyBatis;

import java.time.LocalDate;

public class BoardVO {
	private int boardNo;
	private String title;
	private String user;
	private String content;
	private LocalDate regDt;
	
	public BoardVO() {

	}
	
	public BoardVO(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}
	
	public BoardVO(String title, String user, String content) {
		super();
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public BoardVO(int boardNo, String title, String user, String content, LocalDate regDt) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDate regDt) {
		this.regDt = regDt;
	}
	
}
