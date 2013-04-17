package com.best.demo.pm.service;

import java.util.List;

import com.best.demo.pm.entity.ProdOrd;
import com.best.demo.pm.entity.ProdOrdRel;

public interface ProdOrdService {

	public ProdOrd requireProds(ProdOrd ord, List<ProdOrdRel> rels);
	
}
