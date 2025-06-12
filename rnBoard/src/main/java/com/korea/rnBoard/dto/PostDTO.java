package com.korea.rnBoard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.korea.rnBoard.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //setter, getter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 갖는 생성자.
public class PostDTO {
	
	private Long id;
	private String title;
	private String author;
	private String description;
	private int views;
	private String time;
	
	public static PostDTO fromEntity(Post entity) {
		return PostDTO.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.author(entity.getAuthor())
				.description(entity.getDescription())
				.views(entity.getViews())
				.time(LocalDateTime.now()
	                    .format(DateTimeFormatter.ofPattern("HH:mm")))
				.build();
	}
	
	public static Post fromDTO(PostDTO dto) {
		return Post.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.description(dto.getDescription())
				.views(dto.getViews())
				.time(dto.getTime())
				.build();
	}

}
