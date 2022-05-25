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
}