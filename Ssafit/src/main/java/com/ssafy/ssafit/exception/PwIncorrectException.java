package com.ssafy.ssafit.exception;

public class PwIncorrectException extends Exception{
	public PwIncorrectException() {
		super("비밀번호가 틀립니다.");
	}
}
