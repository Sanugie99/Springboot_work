package com.korea.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.product.dto.ProductDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	
	//추가
	public List<ProductDTO> addProduct(ProductDTO dto){
		ProductEntity entity = ProductDTO.toEntity(dto);
		//jpa로 데이터베이스에 CRUD할 때 반드시 entity로만 해야한다.
		repository.save(entity);
		return repository.findAll()
				.stream()
				.map(ProductDTO::new)
				.collect(Collectors.toList());
	}
	
	//조회(최소금액이 있다면 최소금액 이상의 제품만 조회)
	public List<ProductDTO> getFilteredProducts(Double minPrice){
		//일단 전체 조회를 한다.
		List<ProductEntity> products = repository.findAll();
		
		//가격 필터링(minPrice가 있을 경우)
		if(minPrice != null) {
			products = products
						.stream()
						.filter(product -> product.getPrice() >= minPrice)
						.collect(Collectors.toList());
					
		}
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}
	
	
	
	
	
	//수정
	
	//삭제
	
	
	
	
	
	
	
	
}
