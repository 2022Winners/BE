package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.LikeDao;
import com.ssafy.ssafit.model.dao.PostDao;
import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Post;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeDao likeDao;
	
	@Autowired
	private PostService postService;
	
	@Override
	public void insert(Like like) {
		likeDao.registLike(like);
		postService.plusLikeCnt(like.getPostId());		
	}

	@Override
	public void delete(Like like) {
		likeDao.deleteLike(like);
		postService.minusLikeCnt(like.getPostId());	
	}

	@Override
	public List<Like> LikeList(int userId) {
		List<Like> list = likeDao.selectLikePost(userId);
		return list;
	}

}