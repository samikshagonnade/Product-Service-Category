package com.root.repo;

import java.util.List;

import com.root.entity.Supplier;

public interface SupplierRepo {
	public Supplier addSupplier(Supplier supplier);
	public Supplier getSupplierById(Long supplierId);
	public List<Supplier> getSupplierByName(String supplierName);
	public List<Supplier> getAllSupplier();
}
