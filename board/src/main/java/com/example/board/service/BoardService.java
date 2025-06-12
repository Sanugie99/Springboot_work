package com.example.board.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.board.dto.BoardDTO;
import com.example.board.model.BoardEntity;
import com.example.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository repository;

	//게시글 조회
	public List<BoardDTO> getAllPosts() {
		return repository.findAll().stream()
				.map(BoardDTO::fromEntity)
				.collect(Collectors.toList());
	}

	//게시글 추가
	public List<BoardDTO> createPost(BoardDTO dto) {
		BoardEntity entity = BoardDTO.fromDTO(dto);
		repository.save(entity);
		return getAllPosts();
	}

	//한건 조회
	public BoardDTO getPostById(Long id) {
		 //id에 해당하는 게시물이 존재하는지 찾는다.
		Optional<BoardEntity> option = repository.findById(id);
		
		BoardEntity entity = option.get();
		
		return BoardDTO.fromEntity(entity);
		
	}

	public boolean delePost(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
		
	}

	public BoardDTO updatePost(Long id, BoardDTO dto) {
		//기존의 내용을 꺼냄
		BoardEntity entity =repository.findById(id).get();
		
		//수정한 내용을 entity
		entity.setTitle(dto.getTitle());
		entity.setAuthor(dto.getAuthor());
		entity.setContent(dto.getContent());
		
		return BoardDTO.fromEntity(repository.save(entity));
		
	}
	

	
	

	
}







