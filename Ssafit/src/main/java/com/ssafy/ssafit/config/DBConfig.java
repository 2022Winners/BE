package com.ssafy.ssafit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// 데이터베이스 연관 환경 설정
@Configuration
@MapperScan(basePackages = "com.ssafy.ssafit.model.dao")
public class DBConfig {
}