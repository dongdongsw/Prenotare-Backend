package com.sist.web.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.MainRoomTop3DTO;
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

	
	@Query(value = """
			SELECT no, name, personnel, thumbnail, opentime, closetime, status, hit
			FROM room
			ORDER BY hit DESC
			LIMIT 0, 3
			""", nativeQuery = true)
	public List<MainRoomTop3DTO> mainHitTop3();
	
}
