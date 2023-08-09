package com.root.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private Long productId;
	
	@NotBlank(message = "Please Enter Product Name")
	@Pattern(regexp = "^[A-Za-z].{2,}$", message = "Please Enter Valid Product Name")
	private String productName;
	// Name Should Contains Character and Digit
	// Name Should be greater than 3 characters
	
	private SupplierDto supplierId;
	private CategoryDto categoryId;
	private Long productQuantity;
	private Double productPrice;
}
