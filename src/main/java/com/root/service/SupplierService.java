package com.root.service;

import java.util.List;

import com.root.entity.Supplier;
import com.root.payloads.SupplierDto;

public interface SupplierService {

	public SupplierDto addSupplier(SupplierDto supplier);
	public SupplierDto getSupplierById(Long supplierId);
	public SupplierDto getSupplierByName(String supplierName);
	public List<SupplierDto> getAllSupplier();
}
