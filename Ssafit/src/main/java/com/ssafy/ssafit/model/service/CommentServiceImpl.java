package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.CommentDao;
import com.ssafy.ssafit.model.dto.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public void create(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public Comment getOne(int id) {
		return commentDao.selectOne(id);
	}

	@Override
	public void update(Comment comment) {
		Comment originComment = commentDao.selectOne(comment.getId());
		originComment.setContent(comment.getContent());
		commentDao.updateComment(originComment);
	}

	@Override
	public void delete(int id) {
		commentDao.deleteComment(id);	
	}

	@Override
	public void deleteByPostId(int postId) {
		commentDao.deleteCommentByPostId(postId);
	}

	@Override
	public List<Comment> getListByPostId(int postId) {
		return commentDao.selectListByPostId(postId);
	}

	@Override
	public List<Comment> getListByUserId(int userId) {
		return commentDao.selectListByUserId(userId);
	}
}
