package com.root.repo;

import java.util.List;

import com.root.entity.Supplier;
import com.root.payloads.SupplierDto;

public interface SupplierRepo {
	public Boolean addSupplier(SupplierDto supplierDto);
	public SupplierDto getSupplierById(Long supplierId);
	public SupplierDto getSupplierByName(String supplierName);
	public List<SupplierDto> getAllSupplier();
}
