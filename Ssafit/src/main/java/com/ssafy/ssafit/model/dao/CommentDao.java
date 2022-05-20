package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Comment;

public interface CommentDao {
	// 댓글 추가 insert
	void insertComment(Comment comment);

	// 댓글 조회 selectOne
	Comment selectOne(int id);

	// 게시물에 해당하는 댓글 목록 selectLisByPostId
	List<Comment> selectListByPostId(int postId);

	// 유저가 작성한 모든 댓글 목록 selectLisByUserId
	List<Comment> selectListByUserId(int userId);
		
	// 댓글 수정 update
	void updateComment(Comment comment);

	// 댓글 삭제 delete
	void deleteComment(int id);

	// 게시물 삭제에 따른 댓글 삭제 delete
	void deleteCommentByPostId(int postId);
}
