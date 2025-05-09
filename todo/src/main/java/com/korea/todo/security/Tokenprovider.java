package com.korea.todo.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Tokenprovider {
	
	//비밀키
	private static final String SECRET_KEY = "c6ec4c43b55a2f5d768e0e5dea12a0dd1cba46ebec6bbf95e1008990bb96b2ded26f69f23df0c7a1e3fe32624cc8d7b2441f6217803f5129d8b4439b0658d605b6f048c6c3a7dbecb1f2909b12b65890c50ce988e0866b127e8e76784054d9812178ce953b666d4187b4bf52620f3c3a97204cdbb067da4a9a283f0ef0589b26f260dad5dd63ebef17a33fb2b5575aa56abbaef85ba7e038afccb3ddc25d25bd44a519dade0bdb9358fdc6421d187277ec58a4f20e72a24fbcc7426210b1e5d6b184ae07a6850dc49be71d80e82dc19c69a2c98886c53205045dd9345944deb219a9bdf5cf572f37f4c1954cf4e20151e25cb6ab0ef1650ef4d1e0a17cc1e3bb";
	
	//토큰을 만드는 메서드
	public String create(UserEntity entity) {
		//토큰 만료시간을 설정
		//현재 시각 + 1일
		Date expiryDate = Date.from(Instant.now().plus(1,ChronoUnit.DAYS));
	}
}
