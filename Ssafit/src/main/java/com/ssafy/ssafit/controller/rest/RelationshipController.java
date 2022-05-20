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

@RestController
@RequestMapping("/api")
public class RelationshipController {
	@Autowired
	private RelationshipService relationService;
	
	// C
	@PostMapping("/relation")
	public ResponseEntity<?> follow(Relationship relationship) {
		relationService.follow(relationship);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	// D
	@DeleteMapping("/relation")
	public ResponseEntity<?> unfollow(Relationship relationship) {
		relationService.unfollow(relationship);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}






