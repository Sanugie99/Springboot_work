package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	//서비스 주입
	private final ProductService productService;
	
	//추가
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto){
		List<ProductDTO> response = productService.addProduct(dto);
		return ResponseEntity.ok(response);
	}
	//모든 상품의 조회
	//클라이언트가 최소금액을 전달할 수도 있다.
	@GetMapping
	public ResponseEntity<?> getAllProducts(
			@RequestParam(required=false) Double minPrice){
		List<ProductDTO> products = productService.getFilteredProducts(minPrice);
		return ResponseEntity.ok(products);
	}
	//수정
	
	//삭제
}





