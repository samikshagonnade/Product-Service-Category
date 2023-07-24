package com.root.repo;

import java.util.List;
import java.util.Map;

import com.root.entity.Product;

public interface ProductRepo {
	public Product addProduct(Product product);
	public Product getProductById(Long productId);
	
	
	public Product getProductByName(String productName);
	public List<Product> getAllProducts();
	public Boolean deleteProduct(Long id);
	
	public Boolean updateProductByProductId(Long productId, Map<String, Object> productFields);
	
	public List<Product> sortProducts(String fieldName, String order);
	public List<Product> getMaxPriceProducts();
	public Double countSumOfProductPrice();
	public Long getTotalCountOfProducts();
}
