package com.best.demo.myblog.service.impl;

import java.util.List;

import com.best.demo.myblog.dao.Active;
import com.best.demo.myblog.dao.ActiveDao;
import com.best.demo.myblog.service.ActiveService;

public class ActiveServiceImpl implements ActiveService {

	private ActiveDao activeDao;
	
	public Active addActive(Active active) {
		this.activeDao.save(active);
		return active;
	}

	public List<Active> queryActiveByUser(long uid) {
		return this.activeDao.getActiveByUser(uid);
	}

	public void setActiveDao(ActiveDao activeDao) {
		this.activeDao = activeDao;
	}

}
