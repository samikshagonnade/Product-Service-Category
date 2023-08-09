package com.root.repo;

import java.util.List;
import java.util.Map;

import com.root.entity.Product;
import com.root.payloads.ProductDto;

public interface ProductRepo {
	public Product addProduct(Product product);
	public Product getProductById(Long productId);
	
	
	public List<Product> getProductByName(String productName);
	
	public List<Product> getAllProducts();
	
	public Boolean deleteProduct(Long id);
	
	public Product updateProductById(Long productId, Product product);
	
	public Product updateProductByProductId(Long productId, Map<String, Object> productFields);
	
	public List<Product> sortProducts(String fieldName, String order);
	public List<Product> getMaxPriceProducts();
	public Double sumOfAllProductPrice();
	public Long getTotalCountOfProducts();
}
