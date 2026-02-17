package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.CommentEntity;
import java.util.*;
import com.sist.web.dto.*;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
	
   @Query(value="""
   			SELECT no, room_no, users_no, name, msg, DATE_FORMAT(regdate,'%Y-%m-%d %H:%i:%s') as dbday
		    FROM comment
		    WHERE room_no = :room_no 
		    ORDER BY no DESC
		    """,nativeQuery = true)
   public List<CommentDTO> commentListData(@Param("room_no") int room_no);
   

   public CommentEntity findByNo(int no); 
}