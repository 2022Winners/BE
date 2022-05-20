package com.ssafy.ssafit.model.dto;

import java.util.List;

public class CommentResponse {
	private int id;
	private int userId;
	private int postId;
	private String content;
	private String createdAt;
	private List<Reply> replyList;

	public static CommentResponse build(Comment comment, List<Reply> replys) {
		CommentResponse cr = new CommentResponse();
		cr.setId(comment.getId());
		cr.setUserId(comment.getUserId());
		cr.setPostId(comment.getPostId());
		cr.setContent(comment.getContent());
		cr.setCreatedAt(comment.getCreatedAt());
		cr.setReplyList(replys);
		return cr;
	}
	
	private CommentResponse() {

	}

	private CommentResponse(int id, int userId, int postId, String content, String createdAt, List<Reply> replyList) {
		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.createdAt = createdAt;
		this.replyList = replyList;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "CommentResponse [id=" + id + ", userId=" + userId + ", postId=" + postId + ", content=" + content
				+ ", createdAt=" + createdAt + ", replyList=" + replyList + "]";
	}
	
}
