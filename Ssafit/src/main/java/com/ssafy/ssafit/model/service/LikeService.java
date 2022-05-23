package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.Like;

public interface LikeService {
	// 좋아요 등록
	void insert(Like like);

	// 좋아요 삭제
	void delete(Like like);
}