package com.sist.web.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no; // 사용자 고유 번호
	
	private String id; // 아이디
	private String pwd; // 비밀번호 
	
	private String name; // 닉네임
	private String role; // 사용자 권한
	
	private LocalDateTime createdAt; // 생성 날짜
	private LocalDateTime updatedAt; // 수정 날짜
}
