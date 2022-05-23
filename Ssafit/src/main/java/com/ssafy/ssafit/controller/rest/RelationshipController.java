package com.ssafy.ssafit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Relationship;
import com.ssafy.ssafit.model.service.RelationshipService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class RelationshipController {
	@Autowired
	private RelationshipService relationService;

	@ApiOperation(value = "관계 생성", notes = "userId, followId 값을 입력하여 관계 생성")
	@PostMapping("/relation")
	public ResponseEntity<?> follow(Relationship relationship) {
		relationService.follow(relationship);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "관계 삭제", notes = "userId, followId 값을 입력하여 관계 삭제")
	@DeleteMapping("/relation")
	public ResponseEntity<?> unfollow(Relationship relationship) {
		relationService.unfollow(relationship);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
