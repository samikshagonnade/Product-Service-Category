package com.root.repoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
		Session session = factory.openSession();
		try {
			Supplier supplier = session.get(Supplier.class, supplierId);
			return supplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Supplier> getSupplierByName(String supplierName) {
		Session session = factory.openSession();
		try {
			Criteria criteria = session.createCriteria(Supplier.class);//select * from `product-service-category`.product as product
			List list = criteria.add(Restrictions.ilike("supplierName",supplierName,MatchMode.ANYWHERE)).list();// where(add) product.product_name like(Restrictions.ilike) '%sonic%' (MatchMode);
			if(!list.isEmpty()) {
			 return list;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Supplier> getAllSupplier() {
		Session session = factory.openSession();
		try {
			List list = session.createCriteria(Supplier.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

}
