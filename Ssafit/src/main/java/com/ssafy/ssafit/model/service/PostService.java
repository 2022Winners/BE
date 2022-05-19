package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Post;

public interface PostService {
	void create(Post post);
	void update(Post post);
	void delete(int id);
	void updateViewCnt(int id);
	void updateLikeCnt(int id);
	Post getOne(int id); // 수정, 삭제 시 가져오는 것
	Post readOne(int id); // 실제로 사용자가 원하는 영상게시물
	List<Post> getList(HashMap<String, String> params);
	List<Post> getPartList(String part);
}
