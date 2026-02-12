package com.sist.web.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.RoomListDTO;
import com.sist.web.entity.RoomEntity;

public interface RoomService {

	public Page<RoomListDTO> roomListData(Pageable pg);
	public int roomTotalPage(int start);
	
	public RoomEntity findByNo(int no);
	
	public void roomInsertData(RoomEntity vo);
}
