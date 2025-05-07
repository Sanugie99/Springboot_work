package com.korea.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor //final이나 @NonNull이 붙은 필드를 생성자의 매개변수로 지정
public class UserService {
	
	private final UserRepository repository;
	
	//추가(상용자 생성)
	public List<UserDTO> create(UserEntity entity){	
		repository.save(entity);//데이터베이스에 저장
		
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}
	
	//전체 사용자 조회
	public List<UserDTO> getAllUsers(){
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}


}
