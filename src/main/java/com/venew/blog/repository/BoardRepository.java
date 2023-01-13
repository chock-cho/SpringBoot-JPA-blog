package com.venew.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venew.blog.model.Board;

	public interface BoardRepository extends JpaRepository<Board, Integer> {
		// naming Query : SELECT * FROM user WHERE username = 1?
		// 아무것도 없지만, JPA repository가 findAll()함수를 들고 있다.
	}

