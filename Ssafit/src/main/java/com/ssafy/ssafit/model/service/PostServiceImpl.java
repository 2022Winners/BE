package com.ssafy.ssafit.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dao.PostDao;
import com.ssafy.ssafit.model.dto.Post;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;

	@Override
	public void create(Post post) {
		postDao.insertPost(post);
	}

	@Override
	public void update(Post post) {
		Post origin = postDao.selectOne(post.getId());
		origin.setTitle(post.getTitle());
		origin.setChannel(post.getChannel());
		origin.setPart(post.getPart());
		origin.setVideoId(post.getVideoId());
		postDao.updatePost(post);
	}

	@Override
	public void delete(int id) {
		postDao.deletePost(id);		
	}

	@Override
	public void updateViewCnt(int id) {
		Post post = postDao.selectOne(id);
		post.setViewCnt(post.getViewCnt()+1);
		postDao.updatePost(post);
	}

	@Override
	public void updateLikeCnt(int id) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Post getOne(int id) {
		return postDao.selectOne(id);
	}

	@Override
	public Post readOne(int id) {
		this.updateViewCnt(id);
		return postDao.selectOne(id);
	}

	@Override
	public List<Post> getList(HashMap<String, String> params) {		
		return postDao.selectList(params);
	}

	@Override
	public List<Post> getPartList(String part) {
		return postDao.selectPart(part);
	}
}
