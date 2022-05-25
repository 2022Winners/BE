package com.ssafy.ssafit.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	// 회원가입
	void join(User user, MultipartFile file) throws Exception;

	// 로그인
	Map<String, Object> login(String id, String pw) throws Exception;

	// 회원 정보 수정
	void update(User user) throws Exception;

	// 회원 탈퇴
	void withdrawal(int id);

	// 회원 상세 조회
	Map<String, Object> myPage(int id);

	// 회원 전체 조회
	List<User> getUserList();

	// 내가 팔로우하는 회원 목록 조회
	List<User> getFollowingList(int id);

	// 나를 팔로우하는 회원 목록 조회
	List<User> getFollowerList(int id);

	// login아이디 존재 여부 판단
	boolean isLoginId(String loginId);
}