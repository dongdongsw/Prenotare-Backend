package com.sist.web.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sist.web.dto.RoomListDTO;
import com.sist.web.entity.RoomEntity;
import com.sist.web.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

	private final RoomRepository rRepository;
	private final String uploadPath = "C:/upload/room/";

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

	@Override
	public void roomInsertData(RoomEntity vo, MultipartFile thumbnail, List<MultipartFile>images) throws Exception{
		// TODO Auto-generated method stub
		File dir = new File(uploadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String thumbnailName = UUID.randomUUID() + "_" + thumbnail.getOriginalFilename();
		File thumbnailFile = new File(uploadPath + thumbnailName);
		thumbnail.transferTo(thumbnailFile);
		vo.setThumbnail(thumbnailName);
		
		List<String> imageNames = new ArrayList<>();
		for(MultipartFile file : images) {
			String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
			File saveFile = new File(uploadPath + fileName);
			file.transferTo(saveFile);
			imageNames.add(fileName);
		}
		
		vo.setImages(String.join(" | ", imageNames));
		
		
		rRepository.save(vo);
	}
	
}
