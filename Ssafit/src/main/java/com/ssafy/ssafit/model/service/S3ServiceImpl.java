package com.ssafy.ssafit.model.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ssafy.ssafit.util.S3Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class S3ServiceImpl implements S3Service {

	private final AmazonS3 amazonS3;
	private final S3Component component;

	@Override
	public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
		amazonS3.putObject(new PutObjectRequest(component.getBucket(), fileName, inputStream, objectMetadata)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	@Override
	public String getFileUrl(String fileName) {
		return amazonS3.getUrl(component.getBucket(), fileName).toString();
	}
}
