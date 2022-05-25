package com.ssafy.ssafit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdIncorrectException extends Exception {
	public IdIncorrectException() {
		super("존재하지 않는 아이디입니다.");
	}
}
