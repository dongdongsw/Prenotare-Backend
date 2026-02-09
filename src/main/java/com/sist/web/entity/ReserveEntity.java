package com.sist.web.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reserve")
public class ReserveEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no; // 예약 번호
	
	// 사용자(키값) 조인
	
	// 회의실(키값) 조인 
	
	private String status; // 예약 상태
	
	private LocalDate reserveDate; // 예약 날짜
	private LocalTime startTime; // 예약 시작 시간
	private LocalTime endTime; // 예약 끝나는 시간
	
	private LocalDateTime createAt; // 생성 날짜
	private LocalDateTime updateAt; // 수정 날짜
}
