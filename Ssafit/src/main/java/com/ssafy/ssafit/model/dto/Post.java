package com.ssafy.ssafit.model.dto;

public class Post {
	private int id;
	private String title;
	private String channel;
	private String part;
	private String videoId;
	private int viewCnt;
	private int likeCnt;
	private String createdAt;

	public Post() {

	}

	public Post(int id, String title, String channel, String part, String videoId, int viewCnt, int likeCnt,
			String createdAt) {
		this.id = id;
		this.title = title;
		this.channel = channel;
		this.part = part;
		this.videoId = videoId;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.createdAt = createdAt;
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
		return "Post [id=" + id + ", title=" + title + ", channel=" + channel + ", part=" + part + ", videoId="
				+ videoId + ", viewCnt=" + viewCnt + ", likeCnt=" + likeCnt + ", createdAt=" + createdAt + "]";
	}

}
