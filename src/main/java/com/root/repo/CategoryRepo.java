package com.root.repo;

import java.util.List;

import com.root.entity.Category;

public interface CategoryRepo {

	public Category addCategory(Category category);
	public Category getCategoryById(Long categoryId);
	public Category getCategoryByName(String categoryName);
	public List<Category> getAllCAtegory();
}
