package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.MainRoomTop3DTO;
import com.sist.web.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService{

	private final RoomRepository rRepository;

	@Override
	public List<MainRoomTop3DTO> mainHitTop3() {
		// TODO Auto-generated method stub
		return rRepository.mainHitTop3();
	}
	
	
}
