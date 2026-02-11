package com.sist.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.web.dto.RoomListDTO;
import com.sist.web.entity.RoomEntity;
import com.sist.web.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

	private final RoomRepository rRepository;

	@Override
	public Page<RoomListDTO> roomListData(Pageable pg) {
		// TODO Auto-generated method stub
		return rRepository.roomListData(pg);
	}

	@Override
	public int roomTotalPage(int start) {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(rRepository.count()/12.0));
	}

	@Override
	public RoomEntity findByNo(int no) {
		// TODO Auto-generated method stub
		return rRepository.findByNo(no);
	}
	
}
