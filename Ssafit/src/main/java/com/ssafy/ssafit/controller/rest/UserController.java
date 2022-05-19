package com.ssafy.ssafit.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.exception.UserNotFoundException;
import com.ssafy.ssafit.exception.PwIncorrectException;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@PostMapping(value = "/user/join", consumes = { "multipart/form-data" }) // 회원가입
	public ResponseEntity<?> join(@RequestPart(value = "userData") User user,
			@RequestPart(required = false, value = "file") MultipartFile file) throws Exception {

		userService.join(user, file);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/user/login") // 로그인
	public ResponseEntity<?> login(String loginId, String loginPw) throws Exception {
		userService.login(loginId, loginPw);
		return new ResponseEntity<>(HttpStatus.OK); // 성공했으면 jwt발급한거 리턴해주자~
	}

//
//	@GetMapping("/user") // 로그아웃
//	public ResponseEntity<?> logout(HttpSession session) {
//		userService.logout(session);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//
//	@DeleteMapping("/user/{id}") // 회원탈퇴
//	public ResponseEntity<?> getout(@PathVariable int id) {
//		userService.getout(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	@GetMapping("/user/{id}") // 마이페이지
//	public ResponseEntity<User> myPage(@PathVariable int id) {
//		return new ResponseEntity<User>(userService.myPage(id), HttpStatus.OK);
//	}
//
//	@PutMapping("/user") // 회원정보수정
//	public ResponseEntity<?> updateUser(HttpSession session, User user) {
//		try {
//			userService.update(session, user);
//		} catch (Exception e) { // 실패한경우값???????? 일단 익셉션 생성해서 서비스에서 거기로 넘어감ㅠ
//			e.printStackTrace();
//		}
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}