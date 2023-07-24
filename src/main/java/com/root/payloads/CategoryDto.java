package com.root.payloads;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	private Long categoryId;
	private String categoryName;
	private String discription;
	private Integer discount;
	private Integer gst;
	private Integer deliveryCharge;	
}
