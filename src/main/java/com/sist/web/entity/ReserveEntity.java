package com.sist.web.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="reserve")
@Data
public class ReserveEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no; // 예약 번호
	
	// 사용자(키값) 조인
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_no")
	private UserEntity users;
	
	// 회의실(키값) 조인 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_no")
	private RoomEntity room;
	
	@Column(insertable = false)
	private String status; // 예약 상태
	
	private LocalDate reserveDate; // 예약 날짜
	private String startTime; // 예약 시작 시간
	private String endTime; // 예약 끝나는 시간

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(insertable = false, updatable = false)
	private LocalDate createdAt; // 생성 날짜
	private LocalDate updatedAt; // 수정 날짜
}
