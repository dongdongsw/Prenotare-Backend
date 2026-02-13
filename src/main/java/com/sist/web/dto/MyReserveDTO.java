package com.sist.web.dto;

import java.time.LocalDate;

public interface MyReserveDTO {

	UserInfo getUsers();
	RoomInfo getRoom();
    
    String getStatus();
    LocalDate getReserveDate();
    String getStartTime();
    String getEndTime();
    LocalDate getCreatedAt();
    
    interface UserInfo{
    	Integer getNo();
    }
    
    interface RoomInfo{
    	String getName();
    	Integer getPersonnel();
    	String getThumbnail();
    }
}
