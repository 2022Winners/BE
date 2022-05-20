package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.Relationship;

public interface RelationshipDao {

	// 관계 추가 insert
	void insertRelation(Relationship relationship);
	
	// 관계 삭제 delete
	void deleteRelation(Relationship relationship);
	
}
