package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.UserDTO;
import com.sist.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class UserRestController {

	private final UserService uService;
	
	@GetMapping("/user/login/{id}/{pwd}")
	public ResponseEntity<UserDTO> user_login(@PathVariable("id") String id, @PathVariable("pwd") String pwd){
		
		UserDTO vo = new UserDTO();
		try {
			vo = uService.userLogin(id, pwd);
			vo.setPwd("");
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
}
