package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.dto.PostResponse;

public interface PostService {
	void create(Post post);
	void update(PostResponse postResponse);
	void delete(int id);
	void updateViewCnt(int id);
	void plusLikeCnt(int id); // 좋아요 수 증가
	void minusLikeCnt(int id); // 좋아요 수 감소
	Post getOne(int id); // 수정, 삭제 시 가져오는 것
	PostResponse readOne(int id, int userId); // 실제로 사용자가 원하는 영상게시물
	List<PostResponse> getList(HashMap<String, String> params, int userId);
	List<PostResponse> getPartList(String part, int userId);
	List<PostResponse> hotList(int userId);
}
