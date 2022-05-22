package com.ssafy.ssafit.model.dto;

public class MyComment {
	private int postId;
	private String content;
	private String createdAt;

	public MyComment() {

	}

	public MyComment(int postId, String content, String createdAt) {
		this.postId = postId;
		this.content = content;
		this.createdAt = createdAt;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "MyComment [postId=" + postId + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
	
}
