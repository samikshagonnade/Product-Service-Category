package com.root.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	

	@Column(nullable = false,unique = true)
	private String supplierName;
	

	@Column(nullable = false)
	private String city;
	

	@Column(nullable = false)
	private String postalCode;
	

	@Column(nullable = false)
	private String country;
	

	@Column(nullable = false)
	private String mobileNumber;
}
