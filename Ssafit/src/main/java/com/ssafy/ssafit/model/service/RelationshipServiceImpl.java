package com.ssafy.ssafit.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.exception.PwIncorrectException;
import com.ssafy.ssafit.exception.UserFoundException;
import com.ssafy.ssafit.exception.UserNotFoundException;
import com.ssafy.ssafit.model.dao.RelationshipDao;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.util.SHA256;

@Service
public class RelationshipServiceImpl implements RelationshipService {
//
//	@Autowired
//	private RelationshipDao relDao;
//
//	@Transactional
//	@Override
//	public void join(User user) throws Exception { // 회원가입
//		User preUser = userDao.selectByLoginId(user.getLoginId());
//		if (preUser != null) // 이미 같은 아이디가 존재한다면
//			throw new UserFoundException();
//		else { // 아니면 가입 성공 ~
//			user.setLoginPw((new SHA256().getHash(user.getLoginPw())));
//			userDao.insertUser(user);
//		}
//	}
//
//	@Override
//	public void login(HttpSession session, String loginId, String loginPw) throws Exception { // 로그인
//		User user = userDao.selectByLoginId(loginId);
//		if (user == null)
//			throw new UserNotFoundException();
//		else if (!user.getLoginPw().equals(new SHA256().getHash(loginPw)))
//			throw new PwIncorrectException();
//		else {
//			session.setAttribute("nickname", user.getNickname());
//			session.setAttribute("id", user.getId());
//		}
//	}
//
//	@Override
//	public void logout(HttpSession session) { // 로그아웃
//		session.invalidate();
//	}
//
//	@Override
//	public void getout(int id) { // 회원 탈퇴
//		userDao.deleteUser(id);
//	}
//
//	@Override
//	public User myPage(int id) { // 마이페이지 회원 정보
//		User user = userDao.selectById(id);
//		return user;
//	}
//	
//	@Transactional
//	@Override
//	public void update(HttpSession session, User user) throws Exception{ // 회원 정보 수정
//		user.setLoginPw((new SHA256().getHash(user.getLoginPw())));
//		session.setAttribute("nickname", user.getNickname());
//		userDao.updateUser(user);	
//	}
}