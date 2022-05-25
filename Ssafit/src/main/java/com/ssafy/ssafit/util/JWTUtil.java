package com.ssafy.ssafit.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ssafy.ssafit.exception.JWTException;
import com.ssafy.ssafit.exception.JWTException2;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	private static final String SALT = "koFHDLRLA"; // 비밀키

	// access토큰 생성
	public String createAccessToken() throws UnsupportedEncodingException {
		return Jwts.builder().setHeaderParam("alg", "HS256") // 헤더 정보 입력
				.setHeaderParam("typ", "JWT").setExpiration(new Date(System.currentTimeMillis() + 60000)) // 1분
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명
				.compact(); // 문자열로 생성
	}

	// refresh토큰 생성
	public String createRefreshToken() throws UnsupportedEncodingException {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
				.setExpiration(new Date(System.currentTimeMillis() + 300000)) // 5분
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")).compact();
	}

	// 토큰 검증
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
}
