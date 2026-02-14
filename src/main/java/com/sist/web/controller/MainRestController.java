package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.MainRoomTop3DTO;
import com.sist.web.service.MainService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class MainRestController {

	private final MainService mService;
	
	@GetMapping("/main/hitTop3")
	public ResponseEntity<Map> main_hitTop3(){
		
		Map map = new HashMap<>();
		
		List<MainRoomTop3DTO> list = mService.mainHitTop3();
		
		map.put("list", list);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	
	
}
