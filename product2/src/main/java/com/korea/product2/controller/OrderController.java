package com.korea.product2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.korea.product2.dto.OrderDTO;
import com.korea.product2.dto.ProductDTO;
import com.korea.product2.model.ResponseDTO;
import com.korea.product2.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

	@GetMapping("total")
	public ResponseEntity<?> getAllOrderTotals(){
		List<OrderDTO> list = orderService.getAllOrderTotalPrices();
		ResponseDTO<OrderDTO> response = ResponseDTO.<OrderDTO>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	//주문하기 기능 만들기
	@PostMapping
	public ResponseEntity<?> saveOrder(@RequestBody OrderDTO dto){
		List<ProductDTO> list = orderService.save(dto);
		ResponseDTO<ProductDTO> response = ResponseDTO.<ProductDTO>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
}