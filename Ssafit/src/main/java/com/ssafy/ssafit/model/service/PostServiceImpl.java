package com.ssafy.ssafit.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.LikeDao;
import com.ssafy.ssafit.model.dao.PostDao;
import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.dto.PostResponse;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public void create(Post post) {
		postDao.insertPost(post);
	}

	@Override
	public void update(PostResponse postResponse) {
		Post origin = postDao.selectOne(postResponse.getId());
		origin.setTitle(postResponse.getTitle());
		origin.setChannel(postResponse.getChannel());
		origin.setPart(postResponse.getPart());
		origin.setVideoId(postResponse.getVideoId());
		postDao.updatePost(origin);
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
	public Post getOne(int id) {
		Post post = postDao.selectOne(id);	
		return postDao.selectOne(id);
	}

	@Override
	public PostResponse readOne(int id, int userId) {
		this.updateViewCnt(id);
		Post post = postDao.selectOne(id);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("postId", post.getId());
		PostResponse rp = PostResponse.build(post, likeDao.userLikeVideo(map)==1?true:false);		
		return rp;
	}

	@Override
	public List<PostResponse> getList(HashMap<String, String> params, int userId) {	
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> total = postDao.selectList(params);		
		for(int i = 0; i < total.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", total.get(i).getId());
			PostResponse rp = PostResponse.build(total.get(i), likeDao.userLikeVideo(map)==1?true:false);
			responseList.add(rp);
		}
	    return responseList;
	}

	@Override
	public List<PostResponse> getPartList(String part, int userId) {	
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> partList = postDao.selectPart(part);
		for(int i = 0; i < partList.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", partList.get(i).getId());
			PostResponse rp = PostResponse.build(partList.get(i), likeDao.userLikeVideo(map)==1?true:false);
			responseList.add(rp);
		}
		return responseList;
	}

	@Override
	public void plusLikeCnt(int id) {
		Post post = postDao.selectOne(id);
		post.setLikeCnt(post.getLikeCnt()+1);
		postDao.updatePost(post);
		
	}
	@Override
	public void minusLikeCnt(int id) {
		Post post = postDao.selectOne(id);
		post.setLikeCnt(post.getLikeCnt()-1);
		postDao.updatePost(post);	
	}

	@Override
	public List<PostResponse> hotList(int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> hotList = postDao.HotList();
		for(int i = 0; i < hotList.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", hotList.get(i).getId());
			PostResponse rp = PostResponse.build(hotList.get(i), likeDao.userLikeVideo(map)==1?true:false);
			responseList.add(rp);
		}
		return responseList;
	}
}
