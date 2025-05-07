package com.korea.user.dto;

import com.korea.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//클라이언트와 주고받을때 (요청, 응답) DTO에 담아서 주자
//데이터가 계층간 이동할 때 controller -> service -> repository
//Entity에 담아서 옮기자

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	private Integer id;
	private String name;
	private String email;

	// 생성자(UserEntity -> UserDTO)
	public UserDTO(UserEntity entity) {
	    this.id = entity.getId(); 
	    this.name = entity.getName();
	    this.email = entity.getEmail();
	}

	// UserDTO -> UserEntity
	public static UserEntity toEntity(UserDTO dto) {
		return UserEntity.builder()
				.name(dto.getName())
				.email(dto.getEmail())
				.build();
	}

}
