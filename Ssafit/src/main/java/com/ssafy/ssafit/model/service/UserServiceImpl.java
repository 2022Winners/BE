package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.exception.IdIncorrectException;
import com.ssafy.ssafit.exception.PwIncorrectException;
import com.ssafy.ssafit.model.dao.ImageDao;
import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.Image;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.util.SHA256;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ImageDao imageDao;

	@Autowired
	private FileUploadService fileUploadService;

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

	@Override
	public Map<String, Object> login(String loginId, String loginPw) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		User user = userDao.selectByLoginId(loginId);
		if (user == null) { // loginId로 못 찾은 경우
			throw new IdIncorrectException();
		} else if (!user.getLoginPw().equals(new SHA256().getHash(loginPw))) // 비밀번호가 다른 경우
			throw new PwIncorrectException();
		else { // 로그인 성공
			result.put("user", user);
			Image image = imageDao.selectImage(user.getId());
			if (image != null)
				result.put("image", image);
			return result;
		}
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

	@Override
	public boolean isLoginId(String loginId) {
		List<User> list = userDao.selectUserList();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (loginId.equals(list.get(i).getLoginId()))
				return true;
		}
		return false;
	}
}