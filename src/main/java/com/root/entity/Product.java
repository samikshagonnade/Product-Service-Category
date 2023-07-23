package com.root.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long productId;
	
	
	@Column(nullable = false,unique = true)
	private String productName;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "supplierId")
	private Supplier supplierId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category categoryId;
	
	
	@Column(nullable = false)
	private Long productQuantity;
	

	@Column(nullable = false)
	private Double productPrice;
}
