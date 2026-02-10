package com.sist.web.dto;

import java.time.LocalTime;

public interface RoomListDTO {
	public int getNo();
	public String getName();
	public int getPersonnel();
	public String getThumbnail();
	public String getImages();
	public String getStatus();
	public LocalTime getOpentime();
	public LocalTime getClosetime();
}
