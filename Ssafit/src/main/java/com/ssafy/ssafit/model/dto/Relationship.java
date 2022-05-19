package com.ssafy.ssafit.model.dto;

public class Relationship {
	private int id;
	private int userId;
	private int followId;
	
	public Relationship() {

	}

	public Relationship(int id, int userId, int followId) {
		this.id = id;
		this.userId = userId;
		this.followId = followId;
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

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	@Override
	public String toString() {
		return "Relationship [id=" + id + ", userId=" + userId + ", followId=" + followId + "]";
	}

}
