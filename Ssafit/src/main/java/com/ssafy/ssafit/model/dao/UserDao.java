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

	// 팔로잉 목록 조회 select
	List<User> selectListbyIdo(int id);

	// 팔로워 목록 조회 select
	List<User> selectListbyTheydo(int id);

//	void updateUser(User user);
}