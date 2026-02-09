package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

	private final RoomRepository rRepository;
	
}
