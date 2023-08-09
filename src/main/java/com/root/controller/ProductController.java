package com.root.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.payloads.ProductDto;
import com.root.service.ProductService;

@RestController
@RequestMapping("/product-controller")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct") //Rest End Point
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
	
		ProductDto addProduct = this.service.addProduct(productDto);
		if(addProduct != null  ) {
			return new ResponseEntity<>(addProduct , HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
		ProductDto productDto = this.service.getProductById(productId);
		if(productDto != null) {
			return new ResponseEntity<ProductDto>(productDto, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getProductByName")
	public ResponseEntity<List<ProductDto>> getProductByName(@RequestParam String productName){
		List<ProductDto> ListProductDto = this.service.getProductByName(productName);
		if(!ListProductDto.isEmpty()) {
			return new ResponseEntity<List<ProductDto>>(ListProductDto, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> allProducts = this.service.getAllProducts();
		if(!allProducts.isEmpty()) {
			return new ResponseEntity<List<ProductDto>>(allProducts, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
		Boolean deleteProduct = this.service.deleteProduct(productId);
		if(deleteProduct) {
			return new ResponseEntity<String>("Product Deleted Successfuly : " + productId, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Product with ID : [" + productId + "] Not Exists", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateProductById/{productId}")
	public ResponseEntity<ProductDto> updateProductById(@PathVariable Long productId, @RequestBody ProductDto dto){
		ProductDto productDto = this.service.updateProductById(productId, dto);
		if(productDto != null) {
			return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PatchMapping("/updateProductByProductId/{productId}")
	public ResponseEntity<ProductDto> updateProductByProductId(@PathVariable Long productId, @RequestBody Map<String, Object> productFields){
		ProductDto productDto = this.service.updateProductByProductId(productId, productFields);
		if(productDto != null)
		{
			return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/sortProducts/{fieldName}/{order}")
	public ResponseEntity<List<ProductDto>> sortProducts(@PathVariable String fieldName , @PathVariable String order ){
		List<ProductDto> sortProducts = this.service.sortProducts(fieldName, order);
		if(!sortProducts.isEmpty()) {
			return new ResponseEntity<List<ProductDto>>(sortProducts, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getMaxPriceProducts")
	public ResponseEntity<List<ProductDto>> getMaxPriceProducts(){
		List<ProductDto> maxPriceProducts = this.service.getMaxPriceProducts();
		if(!maxPriceProducts.isEmpty()) {
			return new ResponseEntity<List<ProductDto>>(maxPriceProducts, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/countSumOfProductPrice")
	public ResponseEntity<Double> countSumOfProductPrice(){
		Double productPrice = this.service.sumOfAllProductPrice();
		if(productPrice > 0) {
			return new ResponseEntity<Double>(productPrice, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getTotalCountOfProducts")
	public ResponseEntity<Long> getTotalCountOfProducts(){
		Long count = this.service.getTotalCountOfProducts();
		if(count > 0) {
			return new ResponseEntity<Long>(count, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
