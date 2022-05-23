package com.ssafy.ssafit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	//얘를 컨트롤러클래스 안에 넣어놔도 되는데,
	//ControllerAdvice인 클래스에 모아놓으면 어느 컨트롤러에서나 동작
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, Model model) {
		System.out.println("에러가 발생했습니다.");
		logger.error("Exception 발생 : {}", ex.getMessage());
		model.addAttribute("msg", ex.getMessage());
		System.out.println(ex.getMessage());
		return "error/error";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		logger.error("404 발생 : {}", "404 page not found");
		model.addAttribute("msg", "해당 페이지를 찾을 수 없습니다!!!");
		return "error/error";
	}
	
}

