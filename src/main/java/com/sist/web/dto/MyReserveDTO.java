package com.sist.web.dto;

import java.time.LocalDate;

public interface MyReserveDTO {

	public int getNo();
	public UserInfo getUsers();
	public RoomInfo getRoom();
    
	public String getStatus();
	public LocalDate getReserveDate();
	public String getStartTime();
	public String getEndTime();
	public LocalDate getCreatedAt();
    
    interface UserInfo{
    	Integer getNo();
    }
    
    interface RoomInfo{
    	Integer getNo();
    	String getContent();
    	String getName();
    	Integer getPersonnel();
    	String getThumbnail();
    }
}
