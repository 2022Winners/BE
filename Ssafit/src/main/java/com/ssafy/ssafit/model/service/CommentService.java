package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Comment;
import com.ssafy.ssafit.model.dto.CommentResponse;

public interface CommentService {
	// 댓글 쓰기
	void create(Comment comment);

	// 댓글 읽기
	Comment getOne(int id);

	// 댓글 수정
	void update(Comment comment);

	// 댓글 삭제
	void delete(int id);

	// TODO: post에 기능이 합쳐질 경우, 삭제 예정
	// 게시물에 따른 댓글 삭제
	void deleteByPostId(int postId);

	// 게시물에 해당하는 모든 댓글 조회
	List<CommentResponse> getListByPostId(int postId);

}
