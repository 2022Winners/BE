package com.ssafy.ssafit.model.service;

import java.io.InputStream;

import com.amazonaws.services.s3.model.ObjectMetadata;

public interface S3Service {
	// 파일 업로드
	void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);

	// 업로드한 파일 url 조회
	String getFileUrl(String fileName);
}
