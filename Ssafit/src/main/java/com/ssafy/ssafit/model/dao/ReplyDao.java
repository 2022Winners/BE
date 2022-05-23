package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.MyComment;
import com.ssafy.ssafit.model.dto.Reply;

public interface ReplyDao {
	// 대댓글 추가 insert
	void insertReply(Reply reply);

	// 대댓글 조회 selectOne
	Reply selectOne(int id);

	// 댓글에 해당하는 대댓글 목록 selectListByCommentId
	List<Reply> selectListByCommentId(int commentId);

	// 댓글에 해당하는 대댓글 개수 selectCountByCommentId
	int selectCountByCommentId(int commentId);

	// 대댓글 수정 update
	void updateReply(Reply reply);

	// 대댓글 삭제 delete
	void deleteReply(int id);

	// 게시물 삭제에 따른 대댓글 삭제 delete
	void deleteReplyByPostId(int postId);

	// 해당 유저가 작성한 댓글 + 대댓글 목록 selectListByUserId
	List<MyComment> selectListByUserId(int userId);
}
