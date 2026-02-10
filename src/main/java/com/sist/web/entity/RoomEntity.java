package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="room")
@Data
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no; // 방 번호
	
	private String name; // 방 이름
	private int personnel; // 방 인원
	private String content; // 방 소개
	private String thumbnail; // 방 대표 사진
	private String images; // 방 사진들
	private String status; // 방 이용 가능한지
	private int hit; // 방 조회수
	private LocalTime opentime;  // 오픈 시간
	private LocalTime closetime;  // 닫는 시간
	
	private LocalDateTime createdAt; // 생성 날짜
	private LocalDateTime updatedAt; // 수정 날짜
	
}
