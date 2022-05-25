package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	// 유저 삽입
	int insertUser(User user);

	// 유저 수정
	void updateUser(User user);

	// 유저 로그인 아이디로 조회
	User selectByLoginId(String id);

	// 유저 삭제
	void deleteUser(int id);

	// 유저 아이디로 조회
	User selectById(int id);

	// 유저 전체 목록 조회
	List<User> selectUserList();

	// 내가 팔로우 한 사람들 목록 조회
	List<User> selectFollowingList(int id);

	// 나를 팔로우 한 사람들 목록 조회
	List<User> selectFollowerList(int id);

	// 유저 로그아웃(토큰 수정)
	void logout(int id);
}