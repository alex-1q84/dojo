package com.best.demo.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.best.demo.pm.dao.ProdOrdDao;
import com.best.demo.pm.dao.ProdOrdRelDao;
import com.best.demo.pm.entity.ProdOrd;
import com.best.demo.pm.entity.ProdOrdRel;
import com.best.demo.pm.service.ProdOrdService;

@Component
public class ProdOrdServiceImpl implements ProdOrdService {

	@Autowired
	private ProdOrdDao prodOrdDao;
	
	@Autowired
	private ProdOrdRelDao prodOrdRelDao;
	
	@Override
	public ProdOrd requireProds(ProdOrd ord, List<ProdOrdRel> rels) {
		if(null == rels || rels.isEmpty()){
			return null;
		}
		
		prodOrdDao.save(ord);
		for (ProdOrdRel rel : rels) {
			rel.setProdOrd(ord);
		}
		prodOrdRelDao.saveOrUpdateAll(rels);
		return ord;
	}

}
