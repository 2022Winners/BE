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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Post;
import com.ssafy.ssafit.model.service.PostService;

@RestController
@RequestMapping("/api")
public class RelationshipController {
//	@Autowired
//	private PostService boardService;
//	// C
//	@PostMapping("/board")
//	public ResponseEntity<?> create(@RequestPart(name = "boardData") Post board, @RequestPart(required = false, name = "file") MultipartFile file) {
//		boardService.create(board, file);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	// R - One
//	@GetMapping("/board/{id}")
//	public ResponseEntity<Post> getOne(@PathVariable int id) {
//		return new ResponseEntity<Post>(boardService.getOne(id), HttpStatus.OK);
//	}
//	// R - List
//	@GetMapping("/boards")
//	public ResponseEntity<List<Post>> getList(@RequestParam(defaultValue = "") String mode, @RequestParam(defaultValue = "") String keyword) {
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("mode", mode);
//		params.put("keyword", keyword);
//		return new ResponseEntity<List<Post>>(boardService.getList(params), HttpStatus.OK);
//	}
//	// U
//	@PutMapping("/board/{id}")
//	public ResponseEntity<?> update(@PathVariable int id, Post board, @RequestParam(required=false) MultipartFile file) {	
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






