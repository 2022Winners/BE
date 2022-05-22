package com.ssafy.ssafit.model.service;

import java.io.InputStream;

import com.amazonaws.services.s3.model.ObjectMetadata;

public interface S3Service {
	void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);
	
	String getFileUrl(String fileName);

}
