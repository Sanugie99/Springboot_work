package com.example.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.board.dto.BoardDTO;
import com.example.board.dto.ResponseDTO;
import com.example.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService service;
	
	//전체조회
	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts(){
		List<BoardDTO> list = service.getAllPosts();
		ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	//게시글 추가하기
	@PostMapping("/add")
	public ResponseEntity<?> createPost(@RequestBody BoardDTO dto){
		List<BoardDTO> list = service.createPost(dto);
		ResponseDTO<BoardDTO> response = ResponseDTO
											.<BoardDTO>builder()
											.data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	//id를 통한 게시글 한 건 조회하기("/{id}") (@PathVariable 사용하기)
	@GetMapping("/{id}")
	public ResponseEntity<?> getPostById(@PathVariable Long id){
		BoardDTO dto = service.getPostById(id);
//		ResponseDTO<BoardDTO> response = ResponseDTO
//											.<BoardDTO>builder()
//											.data(dto).build();
		return ResponseEntity.ok().body(dto);
	}
	
	
	//아이디를 통해서 게시글 한 건 삭제하기("/{id}")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id){
		boolean result = service.delePost(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody BoardDTO dto){
		return ResponseEntity.ok(service.updatePost(id,dto)); 
	}
	
}









