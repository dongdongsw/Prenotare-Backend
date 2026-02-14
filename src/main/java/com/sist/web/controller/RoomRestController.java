package com.sist.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.web.dto.MyReserveDTO;
import com.sist.web.dto.RoomListDTO;
import com.sist.web.dto.RoomReserveDTO;
import com.sist.web.entity.ReserveEntity;
import com.sist.web.entity.RoomEntity;
import com.sist.web.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class RoomRestController {

	private final RoomService rService;
	
	@GetMapping("/room/list/{page}") 
	public ResponseEntity<Map> room_list(@PathVariable("page")int page){
		
		Map map = new HashMap<>();
		
		try {
			final int ROWSIZE = 12;
			int start = (page - 1) * ROWSIZE;
			
			Pageable pg = PageRequest.of(page-1, ROWSIZE, Sort.by(Sort.Direction.DESC, "no"));
			Page<RoomListDTO> pList = rService.roomListData(pg);
			List<RoomListDTO> list = new ArrayList<>();
			if(pList != null && pList.hasContent()) {
				list = pList.getContent();
			}
			int totalpage = rService.roomTotalPage(page);
			
			final int BLOCK = 12;
			int startPage = ((page-1)/BLOCK*BLOCK) + 1;
			int endPage = ((page-1)/BLOCK*BLOCK) + BLOCK;
			
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("curpage", page);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/room/detail/{no}") 
	public ResponseEntity<RoomEntity> room_detail(@PathVariable("no") int no){
		
		RoomEntity vo = new RoomEntity();
		List<String> imageList = new ArrayList<>();
		try {
			vo = rService.findByNo(no);
			if(vo.getImages() != null && vo.getImages().contains("|")) {
				for(String image : vo.getImages().split("\\|")) {
					imageList.add(image);
				}
				vo.setImageList(imageList);
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@PostMapping("/room/insert") 
	public ResponseEntity<String> room_insert(
		    @ModelAttribute RoomEntity vo, 
		    @RequestParam("thumbFile") MultipartFile thumbnail,
		    @RequestParam("imageFiles") List<MultipartFile> images
			){

		String res = "";
		try {
			
			res = rService.roomInsertData(vo, thumbnail, images);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@DeleteMapping("/room/delete")
	public ResponseEntity<String> room_delete(@RequestParam("no")int no){
		
		String res = "";
		try {
			res = rService.deleteByNo(no);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/room/reserve")
	public ResponseEntity<String> room_reserve(@RequestBody RoomReserveDTO vo){
		String res = "";
		try {
			res = rService.reserveInsertData(vo);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/mypage/list/{page}/{no}")
	public ResponseEntity<Map> mypage_list(@PathVariable("page") int page, @PathVariable("no") int no){
		
		Map map = new HashMap<>();
		final int ROWSIZE = 3;
		
		int start = (page - 1) * ROWSIZE;

		Pageable pg = PageRequest.of(page-1, ROWSIZE, Sort.by(Sort.Direction.DESC, "no"));
		
		Page<MyReserveDTO> pList = rService.findByUsers_No(pg, no);
		int totalpage = pList.getTotalPages();
		
		final int BLOCK = 12;
		int startPage = ((page-1)/BLOCK*BLOCK) + 1;
		int endPage = ((page-1)/BLOCK*BLOCK) + BLOCK;
		
		map.put("reList", pList.getContent());
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("curpage", page);
		
		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/mypage/reserve/cancel/{no}")
	public ResponseEntity<String> mypage_reserve_cancel(@PathVariable("no") int no){
		
		String res = rService.mypageReserveCancel(no);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
}
