package com.ssafy.ssafit.model.dto;

public class Comment {
	private int id;
	private int userId;
	private int postId;
	private int commentId;
	private String content;
	private String createdAt;

	public Comment() {

	}

	public Comment(int id, int userId, int postId, int commentId, String content, String createdAt) {
		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.commentId = commentId;
		this.content = content;
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

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", postId=" + postId + ", commentId=" + commentId + ", content=" + content
				+ ", createdAt=" + createdAt + "]";
	}

}
