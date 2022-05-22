package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

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
	public void join(User user, MultipartFile file) throws Exception { // 회원가입
		user.setLoginPw((new SHA256().getHash(user.getLoginPw()))); // 비밀번호 변환
		userDao.insertUser(user);// 이미지 없이 유저 삽입
		if (file.getSize() != 0) { // 이미지 있다면
			Image image = fileUploadService.uploadImage(file);
			image.setUserId(user.getId());
			imageDao.insertImage(image);
			user.setImageId(image.getId()); // 이미지 저장하고
			userDao.updateUser(user);// 유저에 이미지아이디 저장해서 업데이트
		}
	}

	@Override
	public void login(String loginId, String loginPw) throws Exception { // 로그인
		User user = userDao.selectByLoginId(loginId);
		if (user == null) // loginId로 못 찾은 경우
			throw new IdIncorrectException();
		else if (!user.getLoginPw().equals(new SHA256().getHash(loginPw))) // 비밀번호가 다른 경우
			throw new PwIncorrectException();
		else {
			System.out.println("ok");
			// 로그인 성공! jwt 발급해주자~
		}
	}

	@Transactional
	@Override
	public void update(User user) throws Exception { // 회원 정보 수정
		user.setLoginPw((new SHA256().getHash(user.getLoginPw())));
		userDao.updateUser(user);
	}

	@Override
	public void getout(int id) { // 회원 탈퇴
		userDao.deleteUser(id);
	}
	
	@Override
	public Map<String, Object> myPage(int id) { // 회원 상세 조회
		User user = userDao.selectById(id);
		Image image = imageDao.selectImage(user.getId());
		Map<String, Object> ret = new HashMap<>();
		ret.put("user", user);
		ret.put("image", image);
		return ret;
	}
	
	@Override
	public List<User> getUserListIdo(int id) { // 내가 팔로우하는 회원 목록 조회
		return userDao.selectListbyIdo(id);
	}

	@Override
	public List<User> getUserListtheydo(int id) { // 날 팔로우하는 회원 목록 조회
		return userDao.selectListbyTheydo(id);
	}

}

//
//
//	@Override
//	public void logout(HttpSession session) { // 로그아웃
//		session.invalidate();
//	}
//
//
//	
