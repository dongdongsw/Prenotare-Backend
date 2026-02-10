package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.RoomListDTO;
import com.sist.web.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

	private final RoomRepository rRepository;

	@Override
	public List<RoomListDTO> roomListData() {
		// TODO Auto-generated method stub
		return rRepository.roomListData();
	}

	@Override
	public int roomTotalPage(int start) {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(rRepository.count()/12.0));
	}
	
}
