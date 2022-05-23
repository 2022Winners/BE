package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private int id;
	private String title;
	private String channel;
	private String part;
	private String videoId;
	private int viewCnt;
	private int likeCnt;
	private String createdAt;
}
