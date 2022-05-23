package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.Relationship;

public interface RelationshipService {

	// 관계 생성
	void follow(Relationship relationship);

	// 관계 삭제
	void unfollow(Relationship relationship);

}