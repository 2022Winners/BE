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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostService postService;

	@ApiOperation(value = "영상 Post 생성", notes = "title, channel, part, video_id 값을 입력하여 영상 Post 생성")
	@PostMapping("/post")
	public ResponseEntity<?> create(Post post) {
		postService.create(post);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "영상 Post 상세보기", notes = "id를 주소에 작성하여 영상 Post 불러오기(userId를 입력하여 해당 유저가 좋아요 눌렀는지 판단)")
	@GetMapping("/post/{id}")
	public ResponseEntity<PostResponse> getOne(@PathVariable int id, @RequestParam(defaultValue = "0") int userId) {
		return new ResponseEntity<PostResponse>(postService.readOne(id, userId), HttpStatus.OK);
	}

	@ApiOperation(value = "파트별 영상 List 불러오기", notes = "part를 주소에 작성하여 파트별 영상 List 불러오기(userId를 입력하여 해당 유저가 좋아요 눌렀는지 판단)")
	@GetMapping("/posts/{part}")
	public ResponseEntity<List<PostResponse>> getPartList(@PathVariable String part,
			@RequestParam(defaultValue = "0") int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.getPartList(part, userId), HttpStatus.OK);
	}

	@ApiOperation(value = "전체 영상 List or 검색한 영상 List 불러오기", notes = "전체 영상 List or mode, keyword로 검색한 영상 List 불러오기(userId를 입력하여 해당 유저가 좋아요 눌렀는지 판단)")
	@GetMapping("/posts")
	public ResponseEntity<List<PostResponse>> getList(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int userId) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<PostResponse>>(postService.getList(params, userId), HttpStatus.OK);
	}

	@ApiOperation(value = "조회순 영상 List 불러오기", notes = "높은 조회순으로 영상 List 불러오기 (userId를 입력하여 해당 유저가 좋아요 눌렀는지 판단)")
	@GetMapping("/posts/top")
	public ResponseEntity<List<PostResponse>> getTopList(@RequestParam(defaultValue = "0") int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.getTopList(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "성별 좋아요 순 영상 List 불러오기", notes = "userId로 해당 유저와 같은 성별을 가진 유저들이 좋아하는 post list 불러오기 (userId를 입력하여 해당 유저가 좋아요 눌렀는지 판단)")
	// 성별 좋아요 누른 영상 top 순위 4개 가져오기
	@GetMapping("/posts/gender")
	public ResponseEntity<List<PostResponse>> getGenderList(@RequestParam int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.getGenderTopList(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "나이별 좋아요 순 영상 List 불러오기", notes = "userId로 해당 유저와 같은 나이대를 가진 유저들이 좋아하는 post list 불러오기 (userId를 입력하여 해당 유저가 좋아요 눌렀는지 판단)")
	// 나이별 좋아요 누른 영상 top 순위 4개 가져오기
	@GetMapping("/posts/age")
	public ResponseEntity<List<PostResponse>> getAgeList(@RequestParam int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.getAgeTopList(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "영상 Post 수정", notes = "title, channel, part, video_id값 입력하여 수정 가능")
	@PutMapping("/post")
	public ResponseEntity<?> update(PostResponse postResponse) {
		postService.update(postResponse);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "영상 Post 삭제", notes = "영상 id값으로 해당 영상 Post 삭제")
	@DeleteMapping("/post/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		postService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "user가 좋아하는 영상 list 불러오기", notes = "userId값을 입력받아 해당 유저가 좋아하는 영상 리스트 불러오기")
	@GetMapping("/posts/like")
	public ResponseEntity<List<PostResponse>> getUserLike(@RequestParam int userId) {
		return new ResponseEntity<List<PostResponse>>(postService.getUserLikeList(userId), HttpStatus.OK);
	}
}
