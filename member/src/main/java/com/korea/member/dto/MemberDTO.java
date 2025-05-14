package com.korea.member.dto;

import com.korea.member.model.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
	
	private int memberId;
	private String name;
	private String email;
	private String password;
	
	public MemberDTO(MemberEntity entity) {
		this.memberId = entity.getMemberId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
	}
	
	public static MemberEntity toEntity(MemberDTO dto) {
		return MemberEntity.builder()
						.memberId(dto.getMemberId())
						.name(dto.getName())
						.email(dto.getEmail())
						.password(dto.getPassword())
						.build();
	}
	
}
