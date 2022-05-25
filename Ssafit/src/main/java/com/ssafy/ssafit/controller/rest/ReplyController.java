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

import com.ssafy.ssafit.model.dto.MyComment;
import com.ssafy.ssafit.model.dto.Reply;
import com.ssafy.ssafit.model.service.ReplyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	@ApiOperation(value = "대댓글 생성", notes = "postId, commentId, userId, content 값을 입력하여 댓글 생성")
	@PostMapping("/reply")
	public ResponseEntity<?> create(@RequestBody Reply reply) {
		replyService.create(reply);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "내가 쓴 댓글 목록 조회", notes = "userId 값을 입력하여 내가 쓴 댓글/대댓글 목록 조회")
	@GetMapping("/replys/user/{userId}")
	public ResponseEntity<List<MyComment>> getListByUserId(@PathVariable int userId) {
		return new ResponseEntity<List<MyComment>>(replyService.getListByUserId(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "대댓글 수정", notes = "replyId 값과, content 값을 입력하여 대댓글 수정")
	@PutMapping("/reply/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Reply reply) {
		replyService.update(reply);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "대댓글 삭제", notes = "replyId 값을 입력하여 대댓글 삭제")
	@DeleteMapping("/reply/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		replyService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
