package com.ssafy.ssafit.model.service;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Image;

public interface FileUploadService {
	// 업로드 된 이미지 정보 담긴 객체 리턴
	Image uploadImage(MultipartFile file);

	// 이미지 고유 이름 생성
	String createFileName(String originalFileName);

	// 이미지 형식 구분
	String getFileExtension(String fileName);
}
