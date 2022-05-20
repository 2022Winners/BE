package com.ssafy.ssafit.controller.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.dto.PostResponse;
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
	public ResponseEntity<PostResponse> getOne(@PathVariable int id, @RequestParam(defaultValue = "0") int userId ) {
		return new ResponseEntity<PostResponse>(postService.readOne(id, userId), HttpStatus.OK);
	}
	
	@GetMapping("/posts/{part}")  
	public ResponseEntity<List<PostResponse>> getPartList(@PathVariable String part, @RequestParam(defaultValue = "0") int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.getPartList(part, userId), HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<List<PostResponse>> getList(@RequestParam(defaultValue = "") String mode, @RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int userId) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<PostResponse>>(postService.getList(params,userId), HttpStatus.OK);
	}
	
	@GetMapping("/posts/hot") 
	public ResponseEntity<List<PostResponse>> getHotList(@RequestParam(defaultValue = "0") int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.hotList(userId), HttpStatus.OK);
	}
	
	@PutMapping("/post")  
	public ResponseEntity<?> update(PostResponse postResponse) {	
		postService.update(postResponse);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/post/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		postService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}






