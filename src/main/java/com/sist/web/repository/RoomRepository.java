package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.dto.RoomListDTO;
import com.sist.web.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer>{

	@Query(value = """
			SELECT no, name, personnel, thumbnail, images, status, hit, opentime, closetime
			FROM room
			ORDER BY no DESC 
			Limit 0, 12
			""", nativeQuery = true)
	public List<RoomListDTO> roomListData();
}
