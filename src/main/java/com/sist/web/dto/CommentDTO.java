package com.sist.web.dto;
// record => 읽기 전용 
public interface CommentDTO {
   public int getNo();
   public int getRoom_no();
   public String getUsers_no();
   public String getName();
   public String getMsg();
   public String getDbday();
}