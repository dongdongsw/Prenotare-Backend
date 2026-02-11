package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public boolean existsById(String id);
	
	public UserEntity findById(String id);
	
}
