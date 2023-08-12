package com.root.repoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
		Session session = factory.openSession();
		try {
			Category category = session.get(Category.class, categoryId);
			return category;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Category> getCategoryByName(String categoryName) {
		Session session = factory.openSession();
		try {
			 Criteria criteria = session.createCriteria(Category.class);
			 List list = criteria.add(Restrictions.ilike("categoryName", categoryName,MatchMode.ANYWHERE)).list();
			 if(!list.isEmpty()) {
				 return list;
			 }else {
					 return null;
				 }
			} catch (Exception e) {
		        e.printStackTrace();
		        return null;
		}finally {
			
			session.close();
		}
	}

	@Override
	public List<Category> getAllCAtegory() {
		Session session = factory.openSession();
		try {
			List list = session.createCriteria(Category.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

}
