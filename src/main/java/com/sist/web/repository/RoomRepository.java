package com.sist.web.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.RoomListDTO;
import com.sist.web.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer>{

	@Query(value = """
			SELECT no, name, personnel, thumbnail, images, status, hit, opentime, closetime
			FROM room
			ORDER BY no DESC 
			""", nativeQuery = true)
	public Page<RoomListDTO> roomListData(Pageable pg);
	
	public RoomEntity findByNo(@Param("no") int no);
	
}
