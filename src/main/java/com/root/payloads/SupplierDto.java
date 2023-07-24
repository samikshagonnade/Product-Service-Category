package com.root.payloads;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
	
	private Long supplierId;
	private String supplierName;
	private String city;
	private String postalCode;
	private String country;
	private String mobileNumber;
}
