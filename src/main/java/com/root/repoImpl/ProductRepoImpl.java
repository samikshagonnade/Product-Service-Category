package com.root.repoImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.root.entity.Product;
import com.root.payloads.ProductDto;
import com.root.repo.ProductRepo;

@Repository
public class ProductRepoImpl implements ProductRepo {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public Product addProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.save(product);
			transaction.commit();
			return product;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateProductByProductId(Long productId, Map<String, Object> productFields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortProducts(String fieldName, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double countSumOfProductPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalCountOfProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
