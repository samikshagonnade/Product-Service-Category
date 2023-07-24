package com.root.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.payloads.SupplierDto;
import com.root.service.SupplierService;

@RestController
@RequestMapping("/supplier-controller")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping("/addSupplier")
	public ResponseEntity<SupplierDto> addSupplier(@RequestBody SupplierDto supplierDto){
		SupplierDto addSupplier = this.supplierService.addSupplier(supplierDto);
		if(addSupplier != null) {
			return new ResponseEntity<SupplierDto>(addSupplier, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
