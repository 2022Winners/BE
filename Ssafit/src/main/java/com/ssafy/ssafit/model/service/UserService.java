package com.ssafy.ssafit.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	void join(User user, MultipartFile file) throws Exception; // 회원가입

	void login(String id, String pw) throws Exception; // 로그인

	void update(User user) throws Exception; // 회원 정보 수정

	void getout(int id); // 회원 탈퇴
	
	Map<String, Object> myPage(int id); // 회원 상세 조회

	List<User> getUserListIdo(int id); // 내가 팔로우하는 회원 목록 조회

	List<User> getUserListtheydo(int id); // 나를 팔로우하는 회원 목록 조회
	
	//	void logout(HttpSession session);
}