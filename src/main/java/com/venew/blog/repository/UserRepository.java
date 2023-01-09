package com.venew.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venew.blog.model.User;

//해당 JpaRepository는 User테이블을 관리하고, User테이블의 primary key는 Integer(숫자)이다.
//DAO (jsp)
//자동으로 bean등록이 된다.
//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
	// JPA naming 쿼리
	// SELECT * FROM user WHERE username = ?1 AND password = ?2
	//User findByUsernameAndPassword(String username, String password);
	
	// @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
	// User login(String username, String password);