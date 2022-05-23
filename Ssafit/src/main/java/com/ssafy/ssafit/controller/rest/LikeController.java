package com.ssafy.ssafit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.service.LikeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@ApiOperation(value = "좋아요 생성", notes = "userId와 postId 값을 받아 like 생성")
	@PostMapping("/like")
	public ResponseEntity<?> create(Like like) {
		likeService.insert(like);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "좋아요 삭제", notes = "userId와 postId 값을 받아 like 삭제")
	@DeleteMapping("/like")
	public ResponseEntity<?> delete(Like like) {
		likeService.delete(like);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}






