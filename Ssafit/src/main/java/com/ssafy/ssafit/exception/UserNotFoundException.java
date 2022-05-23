package com.ssafy.ssafit.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("존재하지 않는 유저입니다.");
	}
}
