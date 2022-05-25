package com.ssafy.ssafit.model.dao;

import java.util.HashMap;

import com.ssafy.ssafit.model.dto.Relationship;

public interface RelationshipDao {
	// 관계 삽입
	void insertRelation(Relationship relationship);

	// 관계 삭제
	void deleteRelation(Relationship relationship);
	
	// 관게 존재 여부
	int checkRelation(HashMap<String, Integer> params);
}
