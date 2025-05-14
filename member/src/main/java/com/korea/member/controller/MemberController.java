package com.korea.member.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Collate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.member.dto.MemberDTO;
import com.korea.member.model.MemberEntity;
import com.korea.member.service.MemberService;
import com.korea.member.dto.ResponseDTO;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {
	
	private final MemberService service;
	
	//조회하기
	@GetMapping
	public ResponseEntity<?> memberList() {
		List<MemberEntity> entities = service.findAll();
		List<MemberDTO> dtos = entities.stream().map(MemberDTO::new).collect(Collectors.toList());
		ResponseDTO<MemberDTO> response = ResponseDTO.<MemberDTO>builder().data(dtos).build();
		return ResponseEntity.ok().body(response);
	}
	
	//추가하기
	@PostMapping
	public ResponseEntity<?> createMember(@RequestBody MemberDTO dto) {
		MemberEntity entity = MemberDTO.toEntity(dto);
		List<MemberEntity> entities = service.create(entity);
		List<MemberDTO> dtos = entities.stream().map(MemberDTO::new).collect(Collectors.toList());
		ResponseDTO<MemberDTO> response = ResponseDTO.<MemberDTO>builder().data(dtos).build();
		return ResponseEntity.ok().body(response);
	}
	
	//삭제하기
	@DeleteMapping
	public ResponseEntity<?> deleteMember(@AuthenticationPrincipal Integer memberId, @RequestBody MemberDTO dto){
		MemberEntity entity = MemberDTO.toEntity(dto);
		
		entity.setMemberId(memberId);
		
		List<MemberEntity> entities = service.delete(entity);
		List<MemberDTO> dtos = entities.stream().map(MemberDTO::new).collect(Collectors.toList());
		
		ResponseDTO<MemberDTO> response = ResponseDTO.<MemberDTO>builder().data(dtos).build();
		return ResponseEntity.ok().body(response);
	}
}
