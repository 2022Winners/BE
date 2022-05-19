package com.ssafy.ssafit.model.service;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	void join(User user, MultipartFile file) throws Exception; // 회원가입
//	void login(HttpSession session, String id, String pw) throws Exception;
//	void logout(HttpSession session);
//	void getout(int id);
//	User myPage(int id);
//	void update(HttpSession session, User user) throws Exception;
}