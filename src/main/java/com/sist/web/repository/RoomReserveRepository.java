package com.sist.web.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.MyReserveDTO;
import com.sist.web.dto.ReserveDateDTO;
import com.sist.web.entity.ReserveEntity;

public interface RoomReserveRepository extends JpaRepository<ReserveEntity, Integer>{

	public Page<MyReserveDTO> findByUsers_No(Pageable pg, @Param("no") int no);
	
	public ReserveEntity findById(@Param("no") int no);
	
	@Query(value = """
			SELECT room_no, reserve_date, start_time, end_time
			FROM reserve
			WHERE room_no = :no
			AND status != 'CANCEL'
			AND reserve_date = :reserveDate  
			""", nativeQuery = true)
	public List<ReserveDateDTO> reserveDateCheck(@Param("no") int no, @Param("reserveDate")LocalDate reserveDate);
}
