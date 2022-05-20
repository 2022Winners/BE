package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.ReplyDao;
import com.ssafy.ssafit.model.dto.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;
	
	@Transactional
	@Override
	public void create(Reply reply) {
		replyDao.insertReply(reply);
	}

	@Override
	public Reply getOne(int id) {
		return replyDao.selectOne(id);
	}

	@Transactional
	@Override
	public void update(Reply reply) {
		Reply originReply = replyDao.selectOne(reply.getId());
		originReply.setContent(reply.getContent());
		replyDao.updateReply(originReply);
	}

	@Transactional
	@Override
	public void delete(int id) {
		replyDao.deleteReply(id);
	}

	@Transactional
	@Override
	public void deleteByPostId(int postId) {
		replyDao.deleteReplyByPostId(postId);
	}

	@Override
	public List<Reply> getListByCommentId(int commentId) {
		return replyDao.selectListByCommentId(commentId);
	}
}
