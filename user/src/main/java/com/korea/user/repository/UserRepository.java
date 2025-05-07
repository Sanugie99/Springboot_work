package com.korea.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korea.user.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	//추가적으로 사용자 검색 기능이 필요하다면 메서드를 정의할 수 있다.
	List<UserEntity> findByEmail(String email);
	//->조회 되는 내용이 하나 뿐일꺼라 List로 묶는게 아니라 그냥 UserEntity로 시작해도 괜찮다.
}


//- JpaRepository를 상속받는다.
//- 이메일을 통해 유저를 찾는 findByEmail추상메서드를 추가한다.