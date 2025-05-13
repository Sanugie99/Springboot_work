package com.korea.product2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.korea.product2.model.ProductEntity;
import com.korea.product2.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	//레파지토리 파일을 주입
	//메모리에 올라가있는 bean을 변수에 주입한다.
	private final ProductRepository repository;
	
	public List<ProductEntity> findAll() {
		return repository.findAll();
	}
	
	public List<ProductEntity> create(final ProductEntity entity){
		vaildate(entity);
		
		repository.save(entity);
		return repository.findAll();
	}
	
	private void vaildate(final ProductEntity entity) {
	    if(entity == null) {
	        throw new RuntimeException("Entity cannot be null.");
	    }
	}
}
