package com.sist.web.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
@DynamicUpdate
@DynamicInsert

public class CommentEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int no;
   
   @Column(name="room_no", updatable = false , insertable = true)
   private int room_no;
   
   @Column(name="users_no", updatable = false , insertable = true)
   private String users_no;
   
   @Column(updatable = false , insertable = true)
   private String name;
   
   private String msg;
   
   @Column(updatable = false , insertable = true)
   private Date regdate;
}