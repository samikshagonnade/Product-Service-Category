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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;

	@Column(nullable = false,unique = true)
	private String categoryName;
	
	@Column(nullable = false,unique = true)
	private String discription;

	@Column(nullable = false)
	private Integer discount;

	@Column(nullable = false)
	private Integer gst;

	@Column(nullable = false)
	private Integer deliveryCharge;	
}
