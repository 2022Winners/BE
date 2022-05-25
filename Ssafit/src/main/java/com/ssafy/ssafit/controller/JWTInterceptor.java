package com.ssafy.ssafit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ssafit.util.JWTUtil;

@Component
public class JWTInterceptor implements HandlerInterceptor {

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}

		final String token = request.getHeader("token"); // 헤더에서 token 데려오기
		if (token != null) { // 토큰이 있으면 값 인증(access라면 성공 시 해당 메소드 실행, refresh라면 access 발급 메소드일 것)
			jwtUtil.valid(token);
			return true;
		}else
			throw new Exception("유효하지 않은 접근입니다.");
	}

}
