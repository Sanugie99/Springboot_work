package com.korea.rnBoard.dto;

import java.util.*;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDTO<T> {
	private String error;
	private List<T> data;
}
