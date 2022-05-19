package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao{
	void insertUser(User user) throws Exception;
	User selectByLoginId(String id) throws Exception;
	User selectById(int id);
	void deleteUser(int id);
	void updateUser(User user);
}