package com.ssafy.ssafit.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponse {
	private int id;
	private String title;
	private String channel;
	private String part;
	private String videoId;
	private int viewCnt;
	private int likeCnt;
	private String createdAt;
	private boolean islike;
	
	
	public static PostResponse build(Post post, boolean islike) {
		PostResponse pr = new PostResponse();
		pr.setId(post.getId());
		pr.setTitle(post.getTitle());
		pr.setChannel(post.getChannel());
		pr.setPart(post.getPart());
		pr.setVideoId(post.getVideoId());
		pr.setViewCnt(post.getViewCnt());
		pr.setLikeCnt(post.getLikeCnt());
		pr.setCreatedAt(post.getCreatedAt());
		pr.setIslike(islike);
		return pr;
	}

	
}
