package com.root.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private Long productId;
	private String productName;
	private SupplierDto supplierId;
	private CategoryDto categoryId;
	private Long productQuantity;
	private Double productPrice;
}
