package com.root.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.entity.Category;
import com.root.payloads.CategoryDto;
import com.root.payloads.ProductDto;
import com.root.repo.CategoryRepo;
import com.root.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = this.mapper.map(categoryDto, Category.class);
		Category addCategory = this.categoryRepo.addCategory(category);
		return this.mapper.map(addCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		Category category = this.categoryRepo.getCategoryById(categoryId);
		return this.mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategoryByName(String categoryName) {
		List<Category> category = this.categoryRepo.getCategoryByName(categoryName);
		return category.stream().map(e -> this.mapper.map(e, CategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CategoryDto> getAllCAtegory() {
		List<Category> category = this.categoryRepo.getAllCAtegory();
		return category.stream().map(e -> this.mapper.map(e, CategoryDto.class)).collect(Collectors.toList());
	}

}
