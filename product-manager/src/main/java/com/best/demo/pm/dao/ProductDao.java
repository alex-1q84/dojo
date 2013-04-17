package com.best.demo.pm.dao;

import com.best.demo.pm.entity.Product;

public interface ProductDao {

	public abstract void save(Product product);

	public abstract void update(Product product);

	public abstract void delete(Product product);

	public abstract Product findByProdCode(String prodCode);

	public abstract void deleteAll();

	public abstract void saveOrUpdate(Product product);

}