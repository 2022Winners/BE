package com.ssafy.ssafit.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.LikeDao;
import com.ssafy.ssafit.model.dao.PostDao;
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
		origin.setChannelImg(postResponse.getChannelImg());
		postDao.updatePost(origin);
	}

	@Transactional
	@Override
	public void delete(int id) {
		postDao.deletePost(id);
	}

	@Override
	public void updateViewCnt(int id) {
		Post post = postDao.selectOne(id);
		post.setViewCnt(post.getViewCnt() + 1);
		postDao.updatePost(post);
	}

	@Override
	public Post getOne(int id) {
		return postDao.selectOne(id);
	}

	@Override
	public PostResponse readOne(int id, int userId) {
		this.updateViewCnt(id);
		Post post = postDao.selectOne(id);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("postId", post.getId());
		PostResponse rp = PostResponse.build(post, likeDao.userLikeVideo(map) == 1 ? true : false);
		return rp;
	}

	@Override
	public List<PostResponse> getList(HashMap<String, String> params, int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> total = postDao.selectList(params);
		for (int i = 0; i < total.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", total.get(i).getId());
			PostResponse rp = PostResponse.build(total.get(i), likeDao.userLikeVideo(map) == 1 ? true : false);
			responseList.add(rp);
		}
		return responseList;
	}

	@Override
	public List<PostResponse> getPartList(String part, int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> partList = postDao.selectListByPart(part);
		for (int i = 0; i < partList.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", partList.get(i).getId());
			PostResponse rp = PostResponse.build(partList.get(i), likeDao.userLikeVideo(map) == 1 ? true : false);
			responseList.add(rp);
		}
		return responseList;
	}

	@Override
	public void plusLikeCnt(int id) {
		Post post = postDao.selectOne(id);
		post.setLikeCnt(post.getLikeCnt() + 1);
		postDao.updatePost(post);

	}

	@Override
	public void minusLikeCnt(int id) {
		Post post = postDao.selectOne(id);
		post.setLikeCnt(post.getLikeCnt() - 1);
		postDao.updatePost(post);
	}

	@Override
	public List<PostResponse> getTopList(int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> hotList = postDao.selectTopList();
		for (int i = 0; i < hotList.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", hotList.get(i).getId());
			PostResponse rp = PostResponse.build(hotList.get(i), likeDao.userLikeVideo(map) == 1 ? true : false);
			responseList.add(rp);
		}
		return responseList;
	}

	@Override
	public List<PostResponse> getGenderTopList(int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> genderTop = postDao.selectTopListByGender(userId);
		for (int i = 0; i < genderTop.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", genderTop.get(i).getId());
			PostResponse rp = PostResponse.build(genderTop.get(i), likeDao.userLikeVideo(map) == 1 ? true : false);
			responseList.add(rp);
		}
		return responseList;
	}

	@Override
	public List<PostResponse> getAgeTopList(int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> ageTop = postDao.selectTopListByAge(userId);
		for (int i = 0; i < ageTop.size(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("postId", ageTop.get(i).getId());
			PostResponse rp = PostResponse.build(ageTop.get(i), likeDao.userLikeVideo(map) == 1 ? true : false);
			responseList.add(rp);
		}
		return responseList;  
	}

	@Override
	public List<PostResponse> getUserLikeList(int userId) {
		List<PostResponse> responseList = new ArrayList<>();
		List<Post> userLike = postDao.selectUserLikeList(userId);
		for (int i = 0; i < userLike.size(); i++) {
			PostResponse rp = PostResponse.build(userLike.get(i), true);
			responseList.add(rp);
		}
		return responseList;
	}

	@Override
	public List<PostResponse> getUserLikePartList(String part, int userId) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("part", part);
		map.put("userId", Integer.toString(userId));
		List<Post> userLikePart = postDao.selectUserLikePartList(map);
		List<PostResponse> responseList = new ArrayList<>();
		for( int i = 0; i < userLikePart.size(); i++) {
			PostResponse rp = PostResponse.build(userLikePart.get(i), true);
			responseList.add(rp);
		}
		return responseList;
	}
}
