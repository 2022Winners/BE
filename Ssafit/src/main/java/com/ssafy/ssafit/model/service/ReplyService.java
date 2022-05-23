package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.MyComment;
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

	// 해당 유저가 작성한 모든 댓글 + 대댓글 목록
	List<MyComment> getListByUserId(int userId);
}
