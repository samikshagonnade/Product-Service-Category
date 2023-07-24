package com.root.repoImpl;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.entity.Category;
import com.root.repo.CategoryRepo;

@Repository
public class CategoryRepoImpl implements CategoryRepo {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public Category addCategory(Category category) {
		Session session = factory.openSession();
		try {
			session.save(category);
			session.beginTransaction().commit();
			return category;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCAtegory() {
		// TODO Auto-generated method stub
		return null;
	}

}
