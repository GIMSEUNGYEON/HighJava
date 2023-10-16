package board;

import java.time.LocalDate;

public class BoardVO {
	private int boardNum;
	private String title;
	private String user;
	private String content;
	private LocalDate regDt;

	public BoardVO() {
		
	}
	public BoardVO(String title, String user, String content) {
		super();
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	public BoardVO(LocalDate regDt, String title, String user, String content) {
		super();
		this.regDt = regDt;
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", title=" + title + ", user=" + user + ", content=" + content + "]";
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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

