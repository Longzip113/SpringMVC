package com.longnguyen.dto;


public class CommentDTO extends AbstracsDTO<CommentDTO>{

	private int userID;
	private int newID;
	private String content;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getNewID() {
		return newID;
	}
	public void setNewID(int newID) {
		this.newID = newID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
