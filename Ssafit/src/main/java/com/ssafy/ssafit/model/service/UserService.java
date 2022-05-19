package com.ssafy.ssafit.model.service;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	void join(User user, MultipartFile file) throws Exception; // 회원가입
	
	void login(String id, String pw) throws Exception; // 로그인
	
	void update(User user) throws Exception;
//	void logout(HttpSession session);
//	void getout(int id);
//	User myPage(int id);
}