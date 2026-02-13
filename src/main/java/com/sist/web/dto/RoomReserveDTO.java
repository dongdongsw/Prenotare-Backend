package com.sist.web.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RoomReserveDTO {

	private Integer users_no;
	private Integer room_no;
	private String startTime;
	private String endTime;
	private LocalDate reserveDate;
}
