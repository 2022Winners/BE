package com.ssafy.ssafit.model.dto;

public class File {
	private int id;
	private int userId;
	private String name;
	private String uri;
	
	public File() {

	}

	public File(int id, int userId, String name, String uri) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.uri = uri;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", userId=" + userId + ", name=" + name + ", uri=" + uri + "]";
	}

}
