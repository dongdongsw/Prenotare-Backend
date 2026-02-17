package com.sist.web.service;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sist.web.dto.MyReserveDTO;
import com.sist.web.dto.ReserveDateDTO;
import com.sist.web.dto.RoomListDTO;
import com.sist.web.dto.RoomReserveDTO;
import com.sist.web.entity.ReserveEntity;
import com.sist.web.entity.RoomEntity;
import com.sist.web.entity.UserEntity;
import com.sist.web.repository.RoomRepository;
import com.sist.web.repository.RoomReserveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

	private final RoomRepository rRepository;
	private final RoomReserveRepository rReserveRepository;
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
		RoomEntity room = new RoomEntity();
		room = rRepository.findByNo(no);
		room.setHit(room.getHit() + 1);
		rRepository.save(room);
		return room;
	}

	@Transactional
	@Override
	public String roomInsertData(RoomEntity vo, MultipartFile thumbnail, List<MultipartFile>images) throws Exception{
		// TODO Auto-generated method stub
		
		String res = "";
		try {
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
			
			
			RoomEntity saved = rRepository.save(vo);
			
			res = "SUCCESS";
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			res = "FAIL";
			throw new RuntimeException("insert error" + ex);
		}
		
		return res;
	}

	@Override
	public String deleteByNo(int no) {
		// TODO Auto-generated method stub
		String res = "";
		if(rRepository.findByNo(no) != null) {
			rRepository.deleteById(no);
			res = "SUCCESS";
		}
		else {
			res = "FAIL";
		}
		return res;
	}

	@Override
	public String reserveInsertData(RoomReserveDTO vo) {
		// TODO Auto-generated method stub
		String res = "";
		if(vo == null) {
			return res = "FAIL";
		}
		
		ReserveEntity reserve = new ReserveEntity();
		UserEntity user = new UserEntity();
		user.setNo(vo.getUsers_no());
		
		RoomEntity room = new RoomEntity();
		room.setNo(vo.getRoom_no());
		
		reserve.setUsers(user);
		reserve.setRoom(room);
		reserve.setStartTime(vo.getStartTime());
		reserve.setEndTime(vo.getEndTime());
		reserve.setReserveDate(vo.getReserveDate());
		
		rReserveRepository.save(reserve);
		res = "SUCCESS";
		return res;
	}


	@Override
	public Page<MyReserveDTO> findByUsers_No(Pageable pg, int no) {
		// TODO Auto-generated method stub
		return rReserveRepository.findByUsers_No(pg, no);
	}

	@Transactional
	@Override
	public String mypageReserveCancel(int no) {
		// TODO Auto-generated method stub
		
		String res = "";
		try {
			ReserveEntity reserve = rReserveRepository.findById(no);
			reserve.setStatus("CANCEL");
			rReserveRepository.save(reserve);
			res = "SUCCESS";
			
		} catch (Exception ex) {

			res = "FAIL";
			ex.printStackTrace();
			throw new RuntimeException("cancel error" + ex);
		}
		
		
		return res;
	}

	@Override
	public List<ReserveDateDTO> reserveDateCheck(int no, LocalDate reserveDate) {
		// TODO Auto-generated method stub
		
		return rReserveRepository.reserveDateCheck(no, reserveDate);
	}

	
	
}
