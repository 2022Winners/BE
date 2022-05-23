package com.ssafy.ssafit.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.ssafit.model.dto.Image;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileUploadServiceImpl implements FileUploadService {

	private final S3Service s3Service;

	@Override
	public Image uploadImage(MultipartFile file) {
		String fileName = createFileName(file.getOriginalFilename());
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength(file.getSize());
		objectMetadata.setContentType(file.getContentType());
		try (InputStream inputStream = file.getInputStream()) {
			s3Service.uploadFile(inputStream, objectMetadata, fileName);
		} catch (IOException e) {
			throw new IllegalArgumentException(String.format("파일 변환 중 에러 (%s)", file.getOriginalFilename()));
		}
		Image image = new Image();
		image.setName(fileName);
		image.setUri(s3Service.getFileUrl(fileName));
		return image;
	}

	@Override
	public String createFileName(String originalFileName) {
		return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
	}

	@Override
	public String getFileExtension(String fileName) {
		try {
			return fileName.substring(fileName.lastIndexOf("."));
		} catch (StringIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(String.format("잘못된 형식 파일 %s", fileName));
		}

	}
}
