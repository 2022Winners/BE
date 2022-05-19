package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Post;

public interface ReplyService {
	//글쓰기
	void create(Post board, MultipartFile file);
	//글수정
	void update(Post board, MultipartFile file);
	//글삭제
	void delete(int id);
	//조회수 증가
	void updateCnt(int id);
	//글 읽기
	Post getOne(int id);
	//모든게시물 조회
	List<Post> getList(HashMap<String, String> params);
}
