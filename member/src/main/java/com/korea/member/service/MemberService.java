package com.korea.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.korea.member.model.MemberEntity;
import com.korea.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository m_repository;
	
	//멤버 전체 조회
	public List<MemberEntity> findAll(){
		return m_repository.findAll();
	}

	public List<MemberEntity> create(MemberEntity entity) {
		validate(entity);
		
		m_repository.save(entity);
		return m_repository.findAll();
	}
	
	public List<MemberEntity> delete(MemberEntity entity){
		//삭제할 엔티티가 유효한지 확인
		validate(entity);
		
		m_repository.delete(entity);
		
		return m_repository.findByMemberId(entity.getMemberId());
	}
	
	private void validate(MemberEntity entity) {
		if(entity == null) {
			throw new RuntimeException();
		}
		if(entity.getMemberId() == null) {
			
		}
	}

}
