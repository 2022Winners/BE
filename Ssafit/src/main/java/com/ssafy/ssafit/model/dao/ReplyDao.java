package com.ssafy.ssafit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Post;

public interface ReplyDao {
	// 게시글 수정 update
	void updateBoard(Post board);

	// 게시글 삭제 delete
	void deleteBoard(int id);

	// 게시글 추가 insert
	void insertBoard(Post board);

	// 게시글 조회 selectOne
	Post selectOne(int id);

	// 게시글 목록 selectList
	List<Post> selectList(HashMap<String, String> params);
}
