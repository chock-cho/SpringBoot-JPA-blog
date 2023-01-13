package com.venew.blog.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venew.blog.model.Board;
import com.venew.blog.model.User;
import com.venew.blog.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Transactional
	public void 글쓰기(Board board, User user) { //title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

}
