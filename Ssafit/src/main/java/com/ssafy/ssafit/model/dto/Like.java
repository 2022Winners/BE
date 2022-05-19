package com.ssafy.ssafit.model.dto;

public class Like {
	private int id;
	private int userId;
	private int postId;
	
	public Like() {

	}

	public Like(int id, int userId, int postId) {
		this.id = id;
		this.userId = userId;
		this.postId = postId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Relationship [id=" + id + ", userId=" + userId + ", postId=" + postId + "]";
	}

}
