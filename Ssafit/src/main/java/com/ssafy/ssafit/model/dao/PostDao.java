package com.ssafy.ssafit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ssafit.model.dto.Post;

public interface PostDao {
	// 영상 게시글 수정 update
	void updatePost(Post post);

	// 영상 게시글 삭제 delete
	void deletePost(int id);

	// 영상 게시글 추가 insert
	void insertPost(Post post);

	// 영상 게시글 조회 selectOne
	Post selectOne(int id);

	// 영상 게시글 목록 selectList
	List<Post> selectList(HashMap<String, String> params);

	// 파트별 영상 조회
	List<Post> selectListByPart(String part);

	// 탑 8개 영상 조회
	List<Post> selectTopList();
	
	// 탑 4개 영상 조회
	List<Post> selectTop4List();

	// 성별 좋아요 누른 영상 탑 순위
	List<Post> selectTopListByGender(int userId);

	// 나이별 좋아요 누른 영상 탑 순위
	List<Post> selectTopListByAge(int userId);

	// 해당 유저가 좋아요 누른 영상 리스트
	List<Post> selectUserLikeList(int userId);
	
	// 해당 유저가 좋아요 누른 파트별 영상 리스트
	List<Post> selectUserLikePartList(HashMap<String, String> params);

}
