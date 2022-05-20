package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.Relationship;

public interface RelationshipService {
	
	// 팔로우
	void follow(Relationship relationship); 
	
	// 언팔로우
	void unfollow(Relationship relationship); 

}