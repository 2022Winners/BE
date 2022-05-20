package com.ssafy.ssafit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Comment;
import com.ssafy.ssafit.model.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentService commentService;

	// C
	@PostMapping("/comment")
	public ResponseEntity<?> create(@RequestBody Comment comment) {
		commentService.create(comment);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// R - One
	@GetMapping("/comment/{id}")
	public ResponseEntity<Comment> getOne(@PathVariable int id) {
		return new ResponseEntity<Comment>(commentService.getOne(id), HttpStatus.OK);
	}

	// R - List ( PostId )
	@GetMapping("/comments/post/{postId}")
	public ResponseEntity<List<Comment>> getListByPostId(@PathVariable int postId) {
		return new ResponseEntity<List<Comment>>(commentService.getListByPostId(postId), HttpStatus.OK);
	}

	// R - List ( UserId )
	@GetMapping("/comments/user/{userId}")
	public ResponseEntity<List<Comment>> getListByUserId(@PathVariable int userId) {
		return new ResponseEntity<List<Comment>>(commentService.getListByUserId(userId), HttpStatus.OK);
	}

	// U
	@PutMapping("/comment/{id}")
	public ResponseEntity<?> update(@PathVariable int id, Comment comment) {
		commentService.update(comment);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// D
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		commentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// D by PostId
	@DeleteMapping("/comment/post/{postId}")
	public ResponseEntity<?> deleteByPostId(@PathVariable int postId) {
		commentService.deleteByPostId(postId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
