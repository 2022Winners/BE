package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.dto.PostResponse;

public interface PostService {
	// 영상 Post 등록
	void create(Post post);

	// 영상 Post 수정
	void update(PostResponse postResponse);

	// 영상 Post 삭제
	void delete(int id);

	// 영상 조회수 증가
	void updateViewCnt(int id);

	// 좋아요 수 증가
	void plusLikeCnt(int id);

	// 좋아요 수 감소
	void minusLikeCnt(int id);

	// 수정, 삭제 시 조회수 증가하지 않고 post R
	Post getOne(int id);

	// 영상 Post 상세보기에 필요한 Post R
	PostResponse readOne(int id, int userId);

	// 영상 Post 전체 리스트 (검색기능 포함)
	List<PostResponse> getList(HashMap<String, String> params, int userId);

	// 파트별 Post 리스트 검색
	List<PostResponse> getPartList(String part, int userId);

	// 조회수 높은 순으로 Post 리스트 검색
	List<PostResponse> getTopList(int userId);

	// 해당 유저와 같은 성별을 가진 유저들이 좋아하는 순으로 Post 리스트 검색
	List<PostResponse> getGenderTopList(int userId);

	// 해당 유저와 같은 나이대를 가진 유저들이 좋아하는 순으로 Post 리스트 검색
	List<PostResponse> getAgeTopList(int userId);

	// 해당 유저가 좋아요 누른 영상 list 검색
	List<PostResponse> getUserLikeList(int userId);
	
	// 해당 유저가 좋아요 누른 파트별 Post 리스트 검색
	List<PostResponse> getUserLikePartList(String part, int userId);
}
