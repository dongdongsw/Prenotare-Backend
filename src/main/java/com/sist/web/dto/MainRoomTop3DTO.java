package com.sist.web.dto;

import java.time.LocalTime;

public interface MainRoomTop3DTO {

	 public int getNo();
	 public String getName();
	 public int getPersonnel();
	 public String getThumbnail();
	 public LocalTime getOpentime();
	 public LocalTime getClosetime();
	 public String getStatus();
	 public int getHit();
}
