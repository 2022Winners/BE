package com.ssafy.ssafit.model.service;

import java.util.HashMap;

import com.ssafy.ssafit.model.dto.Relationship;

public interface RelationshipService {
	// 관계 생성
	void follow(Relationship relationship);

	// 관계 삭제
	void unfollow(Relationship relationship);
	
	// 관계 존재 여부 확인
	boolean checkFollow(HashMap<String, Integer> params);
}