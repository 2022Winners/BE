package com.ssafy.ssafit.exception;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("같은 아이디가 이미 존재합니다.");
	}
}