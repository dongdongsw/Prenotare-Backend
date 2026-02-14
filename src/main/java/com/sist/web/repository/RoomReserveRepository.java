package com.sist.web.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.MyReserveDTO;
import com.sist.web.entity.ReserveEntity;

public interface RoomReserveRepository extends JpaRepository<ReserveEntity, Integer>{

	public Page<MyReserveDTO> findByUsers_No(Pageable pg, @Param("no") int no);
	
	public ReserveEntity findById(@Param("no") int no);
}
