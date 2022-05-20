package com.ssafy.ssafit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.service.LikeService;

@RestController
@RequestMapping("/api")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/like")
	public ResponseEntity<?> create(Like like) {
		likeService.insert(like);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/like")
	public ResponseEntity<?> delete(Like like) {
		likeService.delete(like);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/like/{id}") // 해당 유저가 좋아요 누른 라이크 리스트
	public ResponseEntity<List<Like>> getList(@PathVariable int id) {
		return new ResponseEntity<List<Like>>(likeService.LikeList(id), HttpStatus.OK);
	}
	
	
}






