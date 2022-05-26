package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	private int id;
	private int userId;
	private String writer;
	private int postId;
	private int commentId;
	private String content;
	private String createdAt;
	
	public Reply(int id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public Reply(int userId, String writer, int postId, int commentId, String content) {
		this.userId = userId;
		this.writer = writer;
		this.postId = postId;
		this.commentId = commentId;
		this.content = content;
	}
}
