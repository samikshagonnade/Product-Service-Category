package com.root.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	private Long categoryId;
	
	@NotBlank(message = "Please Enter Category Name")
	@Pattern(regexp = "^[A-Za-z].{2,}$", message = "Please Enter Valid Category Name")
	private String categoryName;
	
	private String discription;
	private Integer discount;
	private Integer gst;
	private Integer deliveryCharge;	
}
