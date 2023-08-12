package com.root.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.entity.Supplier;
import com.root.payloads.CategoryDto;
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
		Supplier supplier = this.supplierRepo.getSupplierById(supplierId);
		return this.mapper.map(supplier, SupplierDto.class);
	}

	@Override
	public List<SupplierDto> getSupplierByName(String supplierName) {
		List<Supplier> supplier = this.supplierRepo.getSupplierByName(supplierName);
		return supplier.stream().map(e -> this.mapper.map(e, SupplierDto.class)).collect(Collectors.toList());
	}
	
	

	@Override
	public List<SupplierDto> getAllSupplier() {
		List<Supplier> supplier = this.supplierRepo.getAllSupplier();
		return supplier.stream().map(e -> this.mapper.map(e, SupplierDto.class)).collect(Collectors.toList());
	}

}
