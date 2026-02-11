package com.sist.web.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sist.web.dto.RoomListDTO;

public interface RoomService {

	public Page<RoomListDTO> roomListData(Pageable pg);
	public int roomTotalPage(int start);
}
