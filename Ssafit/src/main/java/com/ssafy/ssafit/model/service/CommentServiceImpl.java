package com.ssafy.ssafit.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.CommentDao;
import com.ssafy.ssafit.model.dao.ReplyDao;
import com.ssafy.ssafit.model.dto.Comment;
import com.ssafy.ssafit.model.dto.CommentResponse;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Transactional
	@Override
	public void create(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public Comment getOne(int id) {
		return commentDao.selectOne(id);
	}

	@Transactional
	@Override
	public void update(Comment comment) {
		Comment originComment = commentDao.selectOne(comment.getId());
		originComment.setContent(comment.getContent());
		commentDao.updateComment(originComment);
	}

	@Transactional
	@Override
	public void delete(int id) {
		commentDao.deleteComment(id);	
	}

	@Transactional
	@Override
	public void deleteByPostId(int postId) {
		commentDao.deleteCommentByPostId(postId);
	}

	@Override
	public List<CommentResponse> getListByPostId(int postId) {
		List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();
		List<Comment> comments = commentDao.selectListByPostId(postId);
		
		for(int i = 0; i < comments.size(); i++) {
			CommentResponse comment = CommentResponse.build(comments.get(i), replyDao.selectListByCommentId(comments.get(i).getId()));
			commentResponses.add(comment);
		}
		return commentResponses;
	}

	@Override
	public List<Comment> getListByUserId(int userId) {
		return commentDao.selectListByUserId(userId);
	}
}
