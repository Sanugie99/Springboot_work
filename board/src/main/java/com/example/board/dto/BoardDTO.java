package com.example.board.dto;

import com.example.board.model.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDTO {
	
	private Long id;
	private String title;
	private String author;
	private String writingTime;
	private String content;
	
	public BoardDTO(BoardEntity entity) {
		this.id = entity.getId();
	    this.title = entity.getTitle();
	    this.author = entity.getAuthor();
	    this.content = entity.getContent();
	    this.writingTime = entity.getWritingTime();
	}
	
	public static BoardEntity toEntity(BoardDTO dto) {
		return BoardEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.writingTime(dto.getWritingTime())
				.content(dto.getContent())
				.build();
	}
}
