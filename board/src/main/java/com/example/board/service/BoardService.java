package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.model.BoardEntity;
import com.example.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository repository;

	public List<BoardEntity> getAllPost() {
		return repository.findAll();
	}

	// 게시글 추가하기
	public List<BoardEntity> create(BoardEntity entity) {
		validate(entity);

		repository.save(entity);

		return repository.findAll();
	}

	// 게시글 삭제하기
	public List<BoardEntity> deleteByIdAndReturnList(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("게시글이 존재하지 않습니다.");
		}
		repository.deleteById(id);
		return repository.findAll(); // 삭제 후 남은 모든 게시글 반환
	}

	private void validate(BoardEntity entity) {
		if (entity == null) {
			throw new RuntimeException("Entity cannot be null");
		}
	}

}
