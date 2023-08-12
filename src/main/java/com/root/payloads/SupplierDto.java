package com.root.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
	
	private Long supplierId;
	
	@NotBlank(message = "Please Enter Product Name")
	@Pattern(regexp = "^[A-Za-z].{2,}$", message = "Please Enter Valid Product Name")
	private String supplierName;
	
	private String city;
	private String postalCode;
	private String country;
	private String mobileNumber;
}
