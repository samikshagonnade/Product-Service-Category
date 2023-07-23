package com.root.serviceImpl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.root.entity.Product;
import com.root.payloads.ProductDto;
import com.root.repo.ProductRepo;
import com.root.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		
	Product product = this.mapper.map(productDto, Product.class);
	Product addProduct = this.repo.addProduct(product);
	ProductDto map = this.mapper.map(addProduct, ProductDto.class);
	return map;
		
	}

	@Override
	public ProductDto getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getAllProducts() {
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
	public List<ProductDto> sortProducts(String fieldName, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getMaxPriceProducts() {
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
