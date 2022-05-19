package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.Comment;

public interface CommentService {
	//댓글 쓰기
	void create(Comment comment);
	//댓글 읽기
	Comment selectOne(int id);
	//댓글 수정
	void update(Comment comment);
	//댓글 삭제
	void delete(int id);
	//게시물에 따른 댓글 삭제
	void deleteByPostId(int postId);
//	//모든 댓글 조회
//	List<Comment> getList(HashMap<String, String> params);
}
