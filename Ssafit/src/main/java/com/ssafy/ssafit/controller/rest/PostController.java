package com.ssafy.ssafit.controller.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostService postService;

	
	@PostMapping("/post")
	public ResponseEntity<?> create(Post post) {
		postService.create(post);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<Post> getOne(@PathVariable int id) {
		return new ResponseEntity<Post>(postService.getOne(id), HttpStatus.OK);
	}

	@GetMapping("/boards")
	public ResponseEntity<List<Post>> getList(@RequestParam(defaultValue = "") String mode, @RequestParam(defaultValue = "") String keyword) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<Post>>(postService.getList(params), HttpStatus.OK);
	}
//	// U
//	@PutMapping("/board/{id}")
//	public ResponseEntity<?> update(@PathVariable int id, Post board) {	
//		boardService.update(board, file);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	// D
//	@DeleteMapping("/board/{id}")
//	public ResponseEntity<?> delete(@PathVariable int id) {
//		boardService.delete(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}






