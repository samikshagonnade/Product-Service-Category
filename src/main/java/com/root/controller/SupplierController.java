package com.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.payloads.CategoryDto;
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
	
	@GetMapping ("/getSupplierById/{supplierId}")
	public ResponseEntity<SupplierDto> getSupplierById (@PathVariable Long supplierId){
		SupplierDto supplierDto = this.supplierService.getSupplierById(supplierId);
		if(supplierDto !=null) {
			return new ResponseEntity<SupplierDto>(supplierDto, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping ("/getSupplierByName/{supplierName}")
	public ResponseEntity<List<SupplierDto>> getSupplierByName (@PathVariable String supplierName){
		List<SupplierDto> listSupplierDto = this.supplierService.getSupplierByName(supplierName);
		if (!listSupplierDto.isEmpty()) {
			return new ResponseEntity<List<SupplierDto>>(listSupplierDto, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping ("/getAllSupplier")
	public ResponseEntity<List<SupplierDto>> getAllSupplier() {
		List<SupplierDto> allSupplier = this.supplierService.getAllSupplier();
		if(!allSupplier.isEmpty()) {
			return new ResponseEntity<List<SupplierDto>>(allSupplier, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}	

