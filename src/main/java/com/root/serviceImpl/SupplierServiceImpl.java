package com.root.serviceImpl;

import java.util.List; 

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.entity.Supplier;
import com.root.payloads.SupplierDto;
import com.root.repo.SupplierRepo;
import com.root.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepo supplierRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public SupplierDto addSupplier(SupplierDto supplierDto) {
		Supplier supplier = this.mapper.map(supplierDto, Supplier.class);
		Supplier addSupplier = this.supplierRepo.addSupplier(supplier);
		return this.mapper.map(addSupplier, SupplierDto.class);
	}

	@Override
	public SupplierDto getSupplierById(Long supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDto getSupplierByName(String supplierName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierDto> getAllSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

}
