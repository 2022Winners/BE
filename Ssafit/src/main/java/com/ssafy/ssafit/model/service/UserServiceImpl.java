package com.ssafy.ssafit.model.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
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
	private ServletContext servletContext;

	@Transactional
	@Override
	public void join(User user, MultipartFile file) throws Exception { // 회원가입
		user.setLoginPw((new SHA256().getHash(user.getLoginPw()))); // 비밀번호 변환
		user.setId(userDao.insertUser(user)); // 이미지 없이 유저 삽입
		if (file.getSize() != 0) { // 이미지 있다면
			user.setImageId(imageDao.insertImage(saveImage(user.getId(), file))); // 이미지 저장하고
			userDao.updateUser(user);// 유저에 이미지아이디 저장해서 업데이트
		}
	}

	private Image saveImage(int userId, MultipartFile file) {
		Image image = new Image();

		String uploadPath = servletContext.getRealPath("/file");
		String fileName = file.getOriginalFilename();
		String saveName = UUID.randomUUID() + "";
		File target = new File(uploadPath, saveName);
		if (!new File(uploadPath).exists())
			new File(uploadPath).mkdirs();
		try {
			FileCopyUtils.copy(file.getBytes(), target);
			image.setName(fileName);
			image.setUri(target.getCanonicalPath());
			image.setUserId(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
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
}

//
//
//	@Override
//	public void logout(HttpSession session) { // 로그아웃
//		session.invalidate();
//	}
//
//
//	@Override
//	public User myPage(int id) { // 마이페이지 회원 정보
//		User user = userDao.selectById(id);
//		return user;
//	}
//	
