package com.ssafy.ssafit.model.dto;

public class Comment {
	private int id;
	private int userId;
	private int postId;
	private String content;
	private boolean isDeleted;
	private String createdAt;

	public Comment() {

	}

	public Comment(int id, int userId, int postId, String content, boolean isDeleted, String createdAt) {
		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", postId=" + postId + ", content=" + content
				+ ", isDeleted=" + isDeleted + ", createdAt=" + createdAt + "]";
	}

}