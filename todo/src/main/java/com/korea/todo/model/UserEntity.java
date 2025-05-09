package com.korea.todo.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="username")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id // JPA에서 이 필드가 테이블의 Primary Key임을 나타낸다.
    @GeneratedValue(generator="system-uuid") // id 필드는 자동으로 생성된다. 여기서는 UUID 전략을 사용한다.
    @GenericGenerator(name="system-uuid", strategy="uuid") 
    // Hibernate에서 제공하는 UUID를 생성하는 커스텀 전략을 사용한다. system-uuid라는 이름으로 UUID를 생성하는 방식이다.
    private String id; // 유저에게 고유하게 부여되는 ID. UUID로 생성되며 고유한 값이다.

    @Column(nullable=false) // username 컬럼은 null 값을 허용하지 않는다.
    private String username; // 아이디로 사용할 유저네임. 이메일일 수도 있고, 그냥 문자열일 수도 있다.

    private String password; // 유저의 패스워드.

    private String role; // 유저의 권한. 예를 들어 "관리자", "일반사용자"와 같은 값이 들어갈 수 있다.

    private String authProvider; // 이후 OAuth에서 사용할 유저 정보 제공자 : github
}
