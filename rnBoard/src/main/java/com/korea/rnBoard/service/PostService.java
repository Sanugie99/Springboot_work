package com.korea.rnBoard.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.rnBoard.domain.Post;
import com.korea.rnBoard.dto.PostDTO;
import com.korea.rnBoard.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository repository;
	
	//게시글 전체 조회
	public List<PostDTO> getAllPosts(){
		return repository.findAll().stream()
				.map(PostDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	//게시글 상세 조회
	public PostDTO getPostById(Long id) {
		Optional<Post> option = repository.findById(id);
		Post entity = option.get();
		return PostDTO.fromEntity(entity);
	}
	
	//게시글 추가
	public List<PostDTO> createPost(PostDTO dto){
		Post entity = PostDTO.fromDTO(dto);
		repository.save(entity);
		return getAllPosts();
	}
}
