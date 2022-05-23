package com.ssafy.ssafit.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@ApiOperation(value = "회원가입", notes = "이미지 파일, userData(loginId, loginPw, nickname, email, gender, age, role) 파일을 입력하여 회원 생성", produces = "multipart/form-data")
	@PostMapping(value = "/user/join", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> join(
			@RequestPart(value = "userData") @Parameter(schema = @Schema(type = "string", format = "binary")) User user,
			@RequestPart(required = false, value = "file") MultipartFile file) throws Exception {

		userService.join(user, file);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "로그인", notes = "loginId, loginPw 값을 입력하여 로그인")
	@PostMapping("/user/login")
	public ResponseEntity<User> login(String loginId, String loginPw) throws Exception {
		return new ResponseEntity<User>(userService.login(loginId, loginPw), HttpStatus.OK); // 성공했으면 jwt발급한거 리턴해주자~
	}

	@ApiOperation(value = "회원 정보 수정", notes = "id, imageId, loginPw, nickname, email, gender, age, role)값을 입력하여 회원 정보 수정")
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