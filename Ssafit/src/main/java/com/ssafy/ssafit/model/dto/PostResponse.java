package com.ssafy.ssafit.model.dto;

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
	
	public PostResponse() {

	}
	
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

	public boolean isIslike() {
		return islike;
	}

	public void setIslike(boolean islike) {
		this.islike = islike;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ResPost [id=" + id + ", title=" + title + ", channel=" + channel + ", part=" + part + ", videoId="
				+ videoId + ", viewCnt=" + viewCnt + ", likeCnt=" + likeCnt + ", createdAt=" + createdAt + ", islike="
				+ islike + "]";
	}
}
