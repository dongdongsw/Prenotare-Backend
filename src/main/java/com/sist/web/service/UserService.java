package com.sist.web.service;

import com.sist.web.dto.UserDTO;

public interface UserService {

	public UserDTO userLogin(String id, String pwd);
}
