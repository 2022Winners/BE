package com.ssafy.ssafit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Comment;
import com.ssafy.ssafit.model.dto.CommentResponse;
import com.ssafy.ssafit.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@ApiOperation(value = "댓글 생성", notes = "postId, userId, content 값을 입력하여 댓글 생성")
	@PostMapping("/comment")
	public ResponseEntity<?> create(@RequestBody Comment comment) {
		commentService.create(comment);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "댓글 목록 조회", notes = "postId 값을 입력하여 댓글 생성")
	@GetMapping("/comments/post/{postId}")
	public ResponseEntity<List<CommentResponse>> getListByPostId(@PathVariable int postId) {
		return new ResponseEntity<List<CommentResponse>>(commentService.getListByPostId(postId), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 수정", notes = "commentId 값과, 수정하고자 하는 content 값을 입력하여 댓글 생성")
	@PutMapping("/comment/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Comment comment) {
		commentService.update(comment);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 삭제", notes = "commentId 값을 입력하여 댓글 삭제(대댓글 존재여부에 따른 처리)")
	@GetMapping("/comment/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		commentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
