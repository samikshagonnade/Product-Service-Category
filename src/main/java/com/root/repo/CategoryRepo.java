package com.root.repo;

import java.util.List;

import com.root.entity.Category;
import com.root.payloads.CategoryDto;

public interface CategoryRepo {

	public Category addCategory(Category categoryDto);
	public CategoryDto getCategoryById(Long categoryId);
	public CategoryDto getCategoryByName(String categoryName);
	public List<CategoryDto> getAllCAtegory();
}
