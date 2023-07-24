package com.root.serviceImpl;

import java.util.List; 

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.entity.Category;
import com.root.payloads.CategoryDto;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getAllCAtegory() {
		// TODO Auto-generated method stub
		return null;
	}

}
