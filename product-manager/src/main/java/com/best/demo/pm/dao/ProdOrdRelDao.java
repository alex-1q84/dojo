package com.best.demo.pm.dao;

import java.util.List;

import com.best.demo.pm.entity.ProdOrdRel;

public interface ProdOrdRelDao {

	public void save(ProdOrdRel rel);
	public void saveOrUpdateAll(List<ProdOrdRel> rels);
	public void update(ProdOrdRel rel);
	public void delete(ProdOrdRel rel);
	public void deleteAll();
	
	public List<ProdOrdRel> findByOrdId(int ordId);
}
