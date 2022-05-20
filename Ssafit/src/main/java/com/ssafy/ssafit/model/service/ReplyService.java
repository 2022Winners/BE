package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Reply;

public interface ReplyService {
	// 대댓글 쓰기
	void create(Reply reply);

	// 대댓글 읽기
	Reply getOne(int id);

	// 대댓글 수정
	void update(Reply reply);

	// 대댓글 삭제
	void delete(int id);

	// 게시물에 따른 대댓글 삭제
	void deleteByPostId(int postId);

	// 댓글에 해당하는 모든 대댓글 조회
	List<Reply> getListByCommentId(int postId);
}
