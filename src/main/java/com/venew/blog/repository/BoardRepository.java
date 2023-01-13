package com.venew.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venew.blog.model.Board;

	public interface BoardRepository extends JpaRepository<Board, Integer> {
		// naming Query : SELECT * FROM user WHERE username = 1?

	}

