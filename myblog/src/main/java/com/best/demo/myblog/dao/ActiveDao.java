package com.best.demo.myblog.dao;

import java.util.List;

public interface ActiveDao {

	public Active getActive(long id);
	public List<Active> getActiveByUser(long uid);
	public void save(Active active);
	public void deleteAll();
}
