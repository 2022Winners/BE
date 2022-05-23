package com.ssafy.ssafit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private int imageId;
	private String loginId;
	private String loginPw;
	private String nickname;
	private String email;
	private int gender;
	private int age;
	private boolean role;
	private String createdAt;
}
