package com.sist.web.dto;

import java.time.LocalDate;

public interface ReserveDateDTO {

	public int getRoom_no();
	public LocalDate getReserveDate();
	public String getStartTime();
	public String getEndTime();
	
}
