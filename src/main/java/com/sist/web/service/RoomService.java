package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.RoomListDTO;

public interface RoomService {

	public List<RoomListDTO> roomListData();
	public int roomTotalPage(int start);
}
