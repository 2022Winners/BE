package com.ssafy.ssafit.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.RelationshipDao;
import com.ssafy.ssafit.model.dto.Relationship;

@Service
public class RelationshipServiceImpl implements RelationshipService {

	@Autowired
	private RelationshipDao relationDao;

	@Transactional
	@Override
	public void follow(Relationship relationship) {
		relationDao.insertRelation(relationship);
	}

	@Transactional
	@Override
	public void unfollow(Relationship relationship) {
		relationDao.deleteRelation(relationship);
	}

	@Override
	public boolean checkFollow(HashMap<String, Integer> params) {
		if(relationDao.checkRelation(params) !=0) 
			return true;
		return false;
	}
}