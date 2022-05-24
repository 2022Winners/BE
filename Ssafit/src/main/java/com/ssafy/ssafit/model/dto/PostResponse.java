package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
	private String channelImg;
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
		pr.setChannelImg(post.getChannelImg());
		pr.setIslike(islike);
		return pr;
	}
}
