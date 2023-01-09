package com.venew.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
		

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 
//ORM -> Java(다른 언어) Object -> 테이블로 매핑해준다.
//(email을 em으로 임의로 변경해도, 그대로 MySQL에 반영된다)
@Entity // User 클래스가 스프링 부트가 실행될 때, MySQL에 테이블이 생성된다.
//@DynamicInsert //insert시 null인 필드를 제외시켜준다.

public class User {
	
	@Id //Primary key값
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//프로젝트에서 연결된 DB(MySQL)의 넘버링 전략(auto_increment)을 따라간다.
	
	private int id; // 시퀀스, auto_increment(mySQL)
	@Column(nullable = false, length = 30, unique = true)
	private String username; //아이디
	
	@Column(nullable = false, length = 200) //123456 => 해쉬(비밀번호 암호화)
	private String password; 
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'") //양 옆으로 작은 따옴표를 줘서 문자라는 것을 알려줘야 함
//	private String role; //Enum을 쓰는 게 좋다.(도메인(범위) 설정)
	//Admin, User, Manager 권한
	
	//DB는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는 게 좋다 //ADMIN, USER
	
	@CreatedDate //시간이 자동 입력
	private Timestamp createDate; //java.sql에 있는 Timestamp 클래스
	

}
