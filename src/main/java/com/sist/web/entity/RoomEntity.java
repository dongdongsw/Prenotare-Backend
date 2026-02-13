package com.sist.web.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	
	@Column(insertable = false, updatable = true)
	private String status; // 방 이용 가능한지
	
	private int hit; // 방 조회수
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime opentime;  // 오픈 시간
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime closetime;  // 닫는 시간
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(insertable = false, updatable = false)
	private LocalDate createdAt; // 생성 날짜
	
	private LocalDate updatedAt; // 수정 날짜

	@Transient
	private List<String> imageList;
}
