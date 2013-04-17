package com.best.demo.pm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.best.demo.pm.dao.ProdOrdRelDao;
import com.best.demo.pm.entity.ProdOrdRel;

@Component
public class ProdOrdRelDaoImpl extends CustomHibernateDaoSupport implements
		ProdOrdRelDao {

	@Override
	public void save(ProdOrdRel rel) {
		this.getHibernateTemplate().save(rel);
	}

	@Override
	public void update(ProdOrdRel rel) {
		this.getHibernateTemplate().update(rel);
	}

	@Override
	public void delete(ProdOrdRel rel) {
		this.getHibernateTemplate().delete(rel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdOrdRel> findByOrdId(int ordId) {
		return this.getHibernateTemplate().
			find("from ProdOrdRel o where o.ordId = ?", ordId);
	}

	@Override
	public void saveOrUpdateAll(List<ProdOrdRel> rels) {
		this.getHibernateTemplate().saveOrUpdateAll(rels);
	}

	@Override
	public void deleteAll() {
		this.getHibernateTemplate().bulkUpdate("delete from ProdOrdRel");
	}

}
