package com.ssafy.ssafit.model.service;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Image;

public interface FileUploadService {
	Image uploadImage(MultipartFile file);
	String createFileName(String originalFileName);
	String getFileExtension(String fileName);
}
