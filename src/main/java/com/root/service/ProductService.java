package com.root.service;

import java.util.List;
import java.util.Map;

import com.root.entity.Product;
import com.root.payloads.ProductDto;



public interface ProductService {

	public ProductDto addProduct(ProductDto product);
	public ProductDto getProductById(Long productId);
	
	
	public ProductDto getProductByName(String productName);
	public List<ProductDto> getAllProducts();
	public Boolean deleteProduct(Long id);
	
	public Boolean updateProductByProductId(Long productId, Map<String, Object> productFields);
	
	public List<ProductDto> sortProducts(String fieldName, String order);
	public List<ProductDto> getMaxPriceProducts();
	public Double countSumOfProductPrice();
	public Long getTotalCountOfProducts();
}
