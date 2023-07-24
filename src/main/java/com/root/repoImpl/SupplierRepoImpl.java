package com.root.repoImpl;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.entity.Supplier;
import com.root.repo.SupplierRepo;

@Repository
public class SupplierRepoImpl implements SupplierRepo {

	@Autowired
	private SessionFactory factory;	
	
	@Override
	public Supplier addSupplier(Supplier supplier) {
		Session session = factory.openSession();
		try {
			session.save(supplier);
			session.beginTransaction().commit();
			return supplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Supplier getSupplierById(Long supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier getSupplierByName(String supplierName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

}
