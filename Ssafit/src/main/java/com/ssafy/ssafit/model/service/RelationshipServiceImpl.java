package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.RelationshipDao;
import com.ssafy.ssafit.model.dto.Relationship;

@Service
public class RelationshipServiceImpl implements RelationshipService {

	@Autowired
	private RelationshipDao relationDao;

	@Override
	public void follow(Relationship relationship) {
		relationDao.insertRelation(relationship);
	}

	@Override
	public void unfollow(Relationship relationship) {
		relationDao.deleteRelation(relationship);
	}

}