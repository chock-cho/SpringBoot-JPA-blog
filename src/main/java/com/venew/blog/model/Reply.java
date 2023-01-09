package com.venew.blog.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Lob //대용량 데이터
	private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨
	
	//!-- Foreign Key --!
	@ManyToOne //하나의 게시글에는 여러 개의 댓글이 올 수 있다
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne 
	@JoinColumn(name="userId")//하나의 유저는 여러 개의 댓글을 쓸 수 있다.
	private User user;
	
	@CreatedDate //시간이 자동 입력
	private Timestamp createDate;
}
