package com.root.service;

import java.util.List;

import com.root.entity.Category;
import com.root.payloads.CategoryDto;

public interface CategoryService {
	public CategoryDto addCategory(CategoryDto categoryDto);
	public CategoryDto getCategoryById(Long categoryId);
	public CategoryDto getCategoryByName(String categoryName);
	public List<CategoryDto> getAllCAtegory();
}
