package com.sist.web.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.sist.web.dto.MyReserveDTO;
import com.sist.web.dto.RoomListDTO;
import com.sist.web.dto.RoomReserveDTO;
import com.sist.web.entity.ReserveEntity;
import com.sist.web.entity.RoomEntity;

public interface RoomService {

	public Page<RoomListDTO> roomListData(Pageable pg);
	public int roomTotalPage(int start);
	
	public RoomEntity findByNo(int no);
	
	public String roomInsertData(RoomEntity vo, MultipartFile thumbnail, List<MultipartFile>images) throws Exception;
	
	public String deleteByNo(int no);
	
	public String reserveInsertData(RoomReserveDTO vo);
	
	public Page<MyReserveDTO> findByUsers_No(Pageable pg, int no);
}
