package com.best.demo.pm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.best.demo.pm.dao.ProdOrdDao;
import com.best.demo.pm.entity.ProdOrd;

@Component
public class ProdOrdDaoImpl extends CustomHibernateDaoSupport implements
		ProdOrdDao {

	@Override
	public void save(ProdOrd prodOrd) {
		this.getHibernateTemplate().save(prodOrd);
	}

	@Override
	public void update(ProdOrd prodOrd) {
		this.getHibernateTemplate().update(prodOrd);
	}

	@Override
	public void delete(ProdOrd prodOrd) {
		this.getHibernateTemplate().delete(prodOrd);
	}

	@Override
	public ProdOrd findBySheetCode(String sheetCode) {
		@SuppressWarnings("unchecked")
		List<ProdOrd> result = this.getHibernateTemplate().
			find("from ProdOrd o where o.sheetCode = ?", sheetCode);
		if(result.size() > 0){
			return result.get(0);
		}
		return null;
	}

	@Override
	public void deleteAll() {
		this.getHibernateTemplate().bulkUpdate("delete from ProdOrd");
	}

}
