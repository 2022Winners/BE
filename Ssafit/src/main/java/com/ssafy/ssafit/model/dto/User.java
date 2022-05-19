package com.ssafy.ssafit.model.dto;

public class User {
	private int id;
	private int fileId;
	private String loginId;
	private String loginPw;
	private String nickname;
	private String email;
	private int gender;
	private int age;
	private boolean role;
	private String createdAt;

	public User() {

	}

	public User(int id, int fileId, String loginId, String loginPw, String nickname, String email, int gender, int age,
			boolean role, String createdAt) {
		this.id = id;
		this.fileId = fileId;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.role = role;
		this.createdAt = createdAt;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fileId=" + fileId + ", loginId=" + loginId + ", loginPw=" + loginPw + ", nickname="
				+ nickname + ", email=" + email + ", gender=" + gender + ", age=" + age + ", role=" + role
				+ ", createdAt=" + createdAt + "]";
	}

}
