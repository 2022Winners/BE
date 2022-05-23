package com.ssafy.ssafit.model.dao;

import java.util.HashMap;

import com.ssafy.ssafit.model.dto.Like;

public interface LikeDao {
	// 좋아요 등록
	void registLike(Like like);

	// 좋아요 삭제
	void deleteLike(Like like);

	// 이 영상을 해당 유저가 좋아요 눌렀는지 반환
	Integer userLikeVideo(HashMap<String, Integer> map);
}
