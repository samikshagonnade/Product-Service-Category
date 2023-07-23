package com.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.entity.Product;
import com.root.payloads.ProductDto;
import com.root.service.ProductService;

@RestController
@RequestMapping("/product-controller")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct") //Rest End Point
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
	
		ProductDto addProduct = this.service.addProduct(productDto);
		if(addProduct != null  ) {
			return new ResponseEntity<>(addProduct , HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
