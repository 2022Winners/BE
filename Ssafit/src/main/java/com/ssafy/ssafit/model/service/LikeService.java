package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Post;

public interface LikeService {
	//좋아요 등록
	void insert(Like like);
	//좋아요 삭제
	void delete(Like like);
	//유저가 좋아요 누른 영상 리스트 불러오기
	List<Like> LikeList(int userId);
	
}