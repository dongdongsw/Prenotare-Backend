package com.sist.web.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.dto.*;
import com.sist.web.repository.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.entity.*;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository cRepo;

	@Override
	public List<CommentDTO> commentListData(int room_no) {
		// TODO Auto-generated method stub
		return cRepo.commentListData(room_no);
	}

	@Override
	public List<CommentDTO> commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		
		vo.setRegdate(new Date());
		cRepo.save(vo);
		return cRepo.commentListData(vo.getRoom_no());
	}

	@Override
	public List<CommentDTO> commentDelete(int no, int room_no) {
		// TODO Auto-generated method stub
		CommentEntity vo=cRepo.findByNo(no);
		cRepo.delete(vo);
		return cRepo.commentListData(room_no);
	}

	@Override
	public List<CommentDTO> commentUpdate(int no, String msg) {
		// TODO Auto-generated method stub
		CommentEntity vo=cRepo.findByNo(no);
		vo.setMsg(msg);
		vo.setNo(no);
		cRepo.save(vo);
		return cRepo.commentListData(vo.getRoom_no());
	}

	
}