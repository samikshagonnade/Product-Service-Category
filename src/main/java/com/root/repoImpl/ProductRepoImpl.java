package com.root.repoImpl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List; 
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import com.root.entity.Product;
import com.root.repo.ProductRepo;

@Repository
public class ProductRepoImpl implements ProductRepo {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public Product addProduct(Product product) {
		Session session = factory.openSession();
		try {
			session.save(product);
			session.beginTransaction().commit();
			Product productById = this.getProductById(product.getProductId());
			return productById;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public Product getProductById(Long productId) {
		Session session = factory.openSession();
		try {
			
			Product product = session.get(Product.class, productId);
			return product;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public List<Product> getProductByName(String productName) {
		Session session = factory.openSession();
		try {
			Criteria criteria = session.createCriteria(Product.class); // Select * From Product where product name = 'pen'
			List list = criteria.add(Restrictions.ilike("productName", productName, MatchMode.ANYWHERE)).list();
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

	@SuppressWarnings("deprecation")
	@Override
	public List<Product> getAllProducts() {
		Session session = factory.openSession();
		try {
			
			List list = session.createCriteria(Product.class).list();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public Boolean deleteProduct(Long id) {
		Session session = factory.openSession();
		try {
			session.delete(session.get(Product.class, id));
			session.beginTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Product updateProductById(Long productId, Product product) {
		Session session = this.factory.openSession();
		try {
			Product p = session.get(Product.class, productId);
			
			p.setProductName(product.getProductName());
			p.setProductPrice(product.getProductPrice());
			p.setProductQuantity(product.getProductQuantity());
			
			session.saveOrUpdate(p);
			session.beginTransaction().commit();
			
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public Product updateProductByProductId(Long productId, Map<String, Object> productFields) {
		Product product;
		try (Session session = factory.openSession()) {
			 product = session.get(Product.class, productId);
			if (product != null) 
			{
				productFields.forEach((Key, Value) ->
				{
					Field findField = ReflectionUtils.findField(Product.class, Key);
					findField.setAccessible(true);

					// findField --> (Variable Name / Column Name)
					
					if(findField.getName().equalsIgnoreCase("productQuantity")) {
						
						Integer intValueOfProductQuantity = (Integer) productFields.get(findField.getName());
						@SuppressWarnings("removal")
						Long longValueOfProductQuantity = new Long(intValueOfProductQuantity);
						
						if(longValueOfProductQuantity instanceof Long) {
							ReflectionUtils.setField(findField, product, longValueOfProductQuantity);
						}
						
					}else {
						ReflectionUtils.setField(findField, product, Value);
					}
				});
				session.save(product);
				session.beginTransaction().commit();
				return product;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> sortProducts(String fieldName, String order) {
		List<Product> list = null;
		try (Session session = factory.openSession()) { // select * from product orderby productName desc;
			Criteria criteria = session.createCriteria(Product.class); // select * from product
			if (order.equalsIgnoreCase("asc")) {
				criteria.addOrder(Order.asc(fieldName));
			} else {
				criteria.addOrder(Order.desc(fieldName));
			}
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}
	
	
	// #################################
	
	public Double getMaxPrice() {
		Double maxPrice = 0d;
		try(Session session = factory.openSession()) {
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.max("productPrice"));
			List list = criteria.list();
			if (!list.isEmpty()) {
				maxPrice = (Double) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return maxPrice;
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		List<Product> products = null;
		try(Session session = factory.openSession()) {
			Double maxPrice = getMaxPrice();
			if (maxPrice > 0) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Restrictions.eq("productPrice", maxPrice)); // add -> where
				products = criteria.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return products;
	}

	@Override
	public Double sumOfAllProductPrice() {
		Double sumOfProductPrice = 0d;
		try(Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.sum("productPrice"));
			List list = criteria.list();
			if (!list.isEmpty()) {
				sumOfProductPrice = (Double) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sumOfProductPrice;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Long getTotalCountOfProducts() {
		
		Long count = 0L;
		try(Session session = factory.openSession()) {
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.count("productId"));
			List list = criteria.list();
			if(!list.isEmpty())
			{
				count = (Long) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

}
