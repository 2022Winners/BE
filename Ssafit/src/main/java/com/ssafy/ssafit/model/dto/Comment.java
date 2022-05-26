package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int id;
	private int userId;
	private String writer;
	private int postId;
	private String content;
	private boolean isDeleted;
	private String createdAt;
	
	public Comment(int id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public Comment(int userId, String writer, int postId, String content) {
		this.userId = userId;
		this.writer = writer;
		this.postId = postId;
		this.content = content;
	}
}