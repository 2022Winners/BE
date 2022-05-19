package com.ssafy.ssafit.controller.rest;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user/login") // 로그인
	public ResponseEntity<?> login(HttpSession session, String loginId, String loginPw) throws Exception {
		userService.login(session, loginId, loginPw); // 얘 리턴값 줄지말지 고민
		return new ResponseEntity<>(HttpStatus.OK); // 실패한경우값????????
	}

	@GetMapping("/user") // 로그아웃
	public ResponseEntity<?> logout(HttpSession session) {
		userService.logout(session);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/user/join") // 회원가입
	public ResponseEntity<?> join(User user) {
		try {
			userService.join(user);
		} catch (Exception e) { // 실패한경우값???????? 일단 익셉션 생성해서 서비스에서 거기로 넘어감ㅠ
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/user/{id}") // 회원탈퇴
	public ResponseEntity<?> getout(@PathVariable int id) {
		userService.getout(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/user/{id}") // 마이페이지
	public ResponseEntity<User> myPage(@PathVariable int id) {
		return new ResponseEntity<User>(userService.myPage(id), HttpStatus.OK);
	}

	@PutMapping("/user") // 회원정보수정
	public ResponseEntity<?> updateUser(HttpSession session, User user) {
		try {
			userService.update(session, user);
		} catch (Exception e) { // 실패한경우값???????? 일단 익셉션 생성해서 서비스에서 거기로 넘어감ㅠ
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}