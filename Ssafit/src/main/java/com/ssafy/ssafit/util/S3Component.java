package com.ssafy.ssafit.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "cloud.aws.s3")
@Component
public class S3Component {

	private String bucket;

}
