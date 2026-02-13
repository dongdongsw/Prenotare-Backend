package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.dto.UserDTO;
import com.sist.web.entity.UserEntity;
import com.sist.web.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository uRepository;

	@Override
	public UserDTO userLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		UserDTO user = new UserDTO();
		boolean exist = uRepository.existsById(id);
		user.setRole(uRepository.findById(id).getRole()); 
		user.setNo(uRepository.findById(id).getNo());
		if(exist == false) {
			user.setMsg("NOID");
		}
		else {
			UserEntity userpwd = uRepository.findById(id);
			if(pwd.equals(userpwd.getPwd())) {
				user.setId(id);
				user.setName(userpwd.getName());
				user.setMsg("OK");
			}
			else {
				user.setMsg("NOPWD");
			}
		}
		return user;
	}
	
	
}
