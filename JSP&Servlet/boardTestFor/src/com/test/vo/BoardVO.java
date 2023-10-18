package com.test.vo;

import java.sql.Timestamp;

public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int boardCount;
	private Timestamp boardRegDate;
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public Timestamp getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(Timestamp boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	
	
	
	
}
