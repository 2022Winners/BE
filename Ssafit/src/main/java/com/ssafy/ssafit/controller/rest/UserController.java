package com.ssafy.ssafit.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.exception.IdIncorrectException;
import com.ssafy.ssafit.exception.PwIncorrectException;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@ApiOperation(value = "회원가입", notes = "이미지 파일, loginId, loginPw, nickname, email, gender, age 값을 입력하여 회원 생성")
	@PostMapping(value = "/user/join")
	public ResponseEntity<?> join(@RequestParam(required = false) MultipartFile file, @RequestParam String loginId,
			@RequestParam String loginPw, @RequestParam String nickname, @RequestParam String email,
			@RequestParam int gender, @RequestParam int age) throws Exception {
		User user = new User();
		user.setAge(age);
		user.setEmail(email);
		user.setGender(gender);
		user.setLoginId(loginId);
		user.setLoginPw(loginPw);
		user.setNickname(nickname);
		userService.join(user, file);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "로그인", notes = "loginId, loginPw 값을 입력하여 로그인")
	@PostMapping("/user/login")
	public ResponseEntity<Map<String, Object>> login(String loginId, String loginPw) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			ret = userService.login(loginId, loginPw);
		} catch (IdIncorrectException e) {
			ret.put("errMsg", "해당 아이디의 유저가 없습니다.");
			return new ResponseEntity<Map<String, Object>>(ret, HttpStatus.UNAUTHORIZED);
		} catch (PwIncorrectException e) {
			ret.put("errMsg", "비밀번호가 일치하지 않습니다.");
			return new ResponseEntity<Map<String, Object>>(ret, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Map<String, Object>>(ret, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "아이디 존재 유무 조회", notes = "loginId로 아이디 존재 유무 조회")
	@GetMapping("/user/login/{loginId}")
	public ResponseEntity<?> isLoginId(@PathVariable String loginId) {
		if (userService.isLoginId(loginId))
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		else
			return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "회원 정보 수정", notes = "id, imageId, loginPw, nickname, email, gender, age 값을 입력하여 회원 정보 수정")
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(User user) throws Exception {
		userService.update(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "회원 탈퇴", notes = "id 값을 입력하여 회원 탈퇴")
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> withdrawal(@PathVariable int id) {
		userService.withdrawal(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "회원 상세 조회", notes = "id 값을 입력하여 회원 상세 조회")
	@GetMapping("/user/{id}")
	public ResponseEntity<Map<String, Object>> myPage(@PathVariable int id) {
		return new ResponseEntity<Map<String, Object>>(userService.myPage(id), HttpStatus.OK);
	}

	@ApiOperation(value = "회원 전체 조회", notes = "회원 전체 조회")
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUserList() {
		return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 검색 조회", notes = "mode와 keyword를 입력하여 닉네임, 아이디로 회원 조회")
	@GetMapping("/users/search")
	public ResponseEntity<List<User>> getSearchUserList(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<User>>(userService.getSearchUserList(params), HttpStatus.OK);
	}

	@ApiOperation(value = "팔로잉 목록 조회", notes = "id 값을 입력하여 내가 팔로우 하는 사람 목록 조회")
	@GetMapping("/users/following/{id}")
	public ResponseEntity<List<User>> getFollowingList(@PathVariable int id) {
		return new ResponseEntity<List<User>>(userService.getFollowingList(id), HttpStatus.OK);
	}

	@ApiOperation(value = "팔로워 목록 조회", notes = "id 값을 입력하여 나를 팔로우 하는 사람 목록 조회")
	@GetMapping("/users/follower/{id}")
	public ResponseEntity<List<User>> getFollowerList(@PathVariable int id) {
		return new ResponseEntity<List<User>>(userService.getFollowerList(id), HttpStatus.OK);
	}
}