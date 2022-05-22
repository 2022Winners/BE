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

@RestController
@RequestMapping("/api")
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	// C
	@PostMapping("/reply")
	public ResponseEntity<?> create(@RequestBody Reply reply) {
		replyService.create(reply);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// R - List ( UserId )
	@GetMapping("/replys/user/{userId}")
	public ResponseEntity<List<MyComment>> getListByUserId(@PathVariable int userId) {
		return new ResponseEntity<List<MyComment>>(replyService.getListByUserId(userId), HttpStatus.OK);
	}
	
	// U
	@PutMapping("/reply/{id}")
	public ResponseEntity<?> update(@PathVariable int id, Reply reply) {
		replyService.update(reply);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// D
	@DeleteMapping("/reply/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		replyService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}






