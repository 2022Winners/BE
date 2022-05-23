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
	private int postId;
	private int commentId;
	private String content;
	private String createdAt;
}
