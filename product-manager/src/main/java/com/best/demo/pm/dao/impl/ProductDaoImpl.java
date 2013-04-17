package com.best.demo.pm.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.best.demo.pm.dao.ProductDao;
import com.best.demo.pm.entity.Product;

@Repository("ProductDao")
public class ProductDaoImpl extends CustomHibernateDaoSupport implements ProductDao {

	@Override
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	@Override
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

	@Override
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	@Override
	public Product findByProdCode(String prodCode) {
		String hql = "from Product p where p.prodCode = ?";
		@SuppressWarnings("unchecked")
		List<Product> result = this.getHibernateTemplate().find(hql, prodCode);
		if(result.size() > 0){
			return result.get(0);
		}
		return null;
	}

	@Override
	public void deleteAll() {
		this.getHibernateTemplate().bulkUpdate("delete from Product");
	}

	@Override
	public void saveOrUpdate(Product product) {
		this.getHibernateTemplate().saveOrUpdate(product);
	}

}
