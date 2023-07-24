package com.root.service;

import java.util.List;

import com.root.payloads.SupplierDto;

public interface SupplierService {

	public SupplierDto addSupplier(SupplierDto supplierDto);
	public SupplierDto getSupplierById(Long supplierId);
	public SupplierDto getSupplierByName(String supplierName);
	public List<SupplierDto> getAllSupplier();
}
