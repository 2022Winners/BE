package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.exception.IdIncorrectException;
import com.ssafy.ssafit.exception.PwIncorrectException;
import com.ssafy.ssafit.model.dao.ImageDao;
import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.Image;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.util.JWTUtil;
import com.ssafy.ssafit.util.SHA256;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ImageDao imageDao;

	@Autowired
	private FileUploadService fileUploadService;

	@Autowired
	private JWTUtil jwtUtil;

	@Transactional
	@Override
	public void join(User user, MultipartFile file) throws Exception {
		user.setLoginPw((new SHA256().getHash(user.getLoginPw()))); // 비밀번호 변환
		userDao.insertUser(user);// 이미지 없이 유저 삽입
		if (file != null) { // 이미지 있다면
			Image image = fileUploadService.uploadImage(file);
			image.setUserId(user.getId());
			imageDao.insertImage(image);
			user.setImageId(image.getId());
			userDao.updateUser(user);// 유저에 이미지아이디 저장해서 업데이트
		}
	}

	@Transactional
	@Override
	public Map<String, Object> login(String loginId, String loginPw) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		User user = userDao.selectByLoginId(loginId);
		if (user == null) { // loginId로 못 찾은 경우
			throw new IdIncorrectException();
		} else if (!user.getLoginPw().equals(new SHA256().getHash(loginPw))) // 비밀번호가 다른 경우
			throw new PwIncorrectException();
		else { // 로그인 성공
			user.setRefreshToken(jwtUtil.createRefreshToken());
			result.put("user", user);
			Image image = imageDao.selectImage(user.getId());
			if (image != null)
				result.put("imageUri", image.getUri());
			userDao.updateUser(user); // 발급 받은 refreshToken DB에 업데이트
			result.put("access-token", jwtUtil.createAccessToken());
			result.put("refresh-token", user.getRefreshToken());
			return result;
		}
	}

	@Transactional
	@Override
	public void logout(int id) {
		userDao.logout(id);
	}

	@Transactional
	@Override
	public Map<String, Object> refreshToken(int id, String refreshToken) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		User user = userDao.selectById(id);
		if (user.getRefreshToken().equals(refreshToken)) {
			result.put("user", user);
			result.put("refresh-token", user.getRefreshToken()); // user에 있어서 굳이 두 번 보낼 필요 있을지
			result.put("access-token", jwtUtil.createAccessToken());
		} else // refreshToken이 저장된 것과 다르다면 변조되었을 가능성 있으므로 로그아웃 필요
			throw new Exception("incorrect");
		return result;
	}

	@Transactional
	@Override
	public void update(User user) throws Exception {
		user.setLoginPw((new SHA256().getHash(user.getLoginPw())));
		userDao.updateUser(user);
	}

	@Transactional
	@Override
	public void withdrawal(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public Map<String, Object> myPage(int id) {
		User user = userDao.selectById(id);
		Image image = imageDao.selectImage(user.getId());
		Map<String, Object> ret = new HashMap<>();
		ret.put("user", user);
		ret.put("image", image);
		return ret;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectUserList();
	}

	@Override
	public List<User> getFollowingList(int id) {
		return userDao.selectFollowingList(id);
	}

	@Override
	public List<User> getFollowerList(int id) {
		return userDao.selectFollowerList(id);
	}

}