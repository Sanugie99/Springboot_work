package com.korea.member.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Member")
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;
	private String name;
	private String email;
	private String password;
}
