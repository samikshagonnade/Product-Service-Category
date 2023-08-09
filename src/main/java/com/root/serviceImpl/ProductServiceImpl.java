package com.root.serviceImpl;

import java.util.List; 
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.entity.Product;
import com.root.payloads.ProductDto;
import com.root.repo.ProductRepo;
import com.root.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = this.mapper.map(productDto, Product.class);
		Product addProduct = this.productRepo.addProduct(product);
		return this.mapper.map(addProduct, ProductDto.class);
	}

	@Override
	public ProductDto getProductById(Long productId) {
		Product product = this.productRepo.getProductById(productId);
		return this.mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getProductByName(String productName) { // List(product1 , product 2 ... n )
		List<Product> products = this.productRepo.getProductByName(productName);
		return products.stream().map(eachProduct -> this.mapper.map(eachProduct, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = this.productRepo.getAllProducts();
		return products.stream().map(eachProduct -> this.mapper.map(eachProduct, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public Boolean deleteProduct(Long productId) {
		return this.productRepo.deleteProduct(productId);
	}
	
	@Override
	public ProductDto updateProductById(Long productId, ProductDto productDto) {
		Product product = this.mapper.map(productDto, Product.class);
		Product product2 = this.productRepo.updateProductById(productId, product);
		return this.mapper.map(product2, ProductDto.class);
	}

	@Override
	public ProductDto updateProductByProductId(Long productId, Map<String, Object> productFields) {
		Product product = productRepo.updateProductByProductId(productId, productFields);
		return this.mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> sortProducts(String fieldName, String order) {
		List<Product> sortProducts = this.productRepo.sortProducts(fieldName, order);
		return sortProducts.stream().map(e -> this.mapper.map(e, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getMaxPriceProducts() {
		List<Product> products = this.productRepo.getMaxPriceProducts();
		return products.stream().map(e -> this.mapper.map(e, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public Double sumOfAllProductPrice() {
		return this.productRepo.sumOfAllProductPrice();
	}

	@Override
	public Long getTotalCountOfProducts() {
		return this.productRepo.getTotalCountOfProducts();
	}

}
