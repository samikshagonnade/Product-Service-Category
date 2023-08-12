  package com.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping ("/getCategoryById/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById (@PathVariable Long categoryId)
	{
		CategoryDto categoryDto = this.categoryService.getCategoryById (categoryId);
		if(categoryDto != null)
		{
			return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping ("/getCategoryByName/{categoryName}")
	public ResponseEntity<List<CategoryDto>> getCategoryByName (@PathVariable String categoryName){
		List<CategoryDto> listCategoryDto = this.categoryService.getCategoryByName(categoryName);
		if (!listCategoryDto.isEmpty()) {
			return new ResponseEntity<List<CategoryDto>>(listCategoryDto, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping ("/getAllCAtegory")
	public ResponseEntity<List<CategoryDto>> getAllCAtegory(){
		List<CategoryDto> allCategory = this.categoryService.getAllCAtegory();
		if (!allCategory.isEmpty()) {
			return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
