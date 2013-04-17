package com.best.demo.pm.dao;

import com.best.demo.pm.entity.ProdOrd;

public interface ProdOrdDao {
	
	public void save(ProdOrd prodOrd);
	public void update(ProdOrd prodOrd);
	public void delete(ProdOrd prodOrd);
	public void deleteAll();
	
	public ProdOrd findBySheetCode(String sheetCode);
}
