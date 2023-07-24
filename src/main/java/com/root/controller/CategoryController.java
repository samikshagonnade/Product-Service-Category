package com.root.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.payloads.CategoryDto;
import com.root.service.CategoryService;

@RestController
@RequestMapping("/category-controller")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto addCategory = this.categoryService.addCategory(categoryDto);
		if(addCategory != null) {
			return new ResponseEntity<>(addCategory, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
