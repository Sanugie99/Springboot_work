package com.korea.rnBoard.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.rnBoard.dto.PostDTO;
import com.korea.rnBoard.dto.ResponseDTO;
import com.korea.rnBoard.service.PostService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService service;
	
	//전체조회
	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts(){
		List<PostDTO> list = service.getAllPosts();
		ResponseDTO<PostDTO> response = ResponseDTO.<PostDTO>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	//게시글 상세 조회
	@GetMapping("/posts/{id}")
	public ResponseEntity<?> getPostById(@PathVariable("id") Long id){
		PostDTO dto = service.getPostById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	//게시글 추가하기
	@PostMapping("/posts")
	public ResponseEntity<?> createPost(@RequestBody PostDTO dto){
		List<PostDTO> list = service.createPost(dto);
		ResponseDTO<PostDTO> response = ResponseDTO.<PostDTO>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
}
