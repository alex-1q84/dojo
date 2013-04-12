package com.best.demo.myblog.service;

import java.util.List;

import com.best.demo.myblog.dao.Active;

public interface ActiveService {

	public Active addActive(Active active);
	
	public List<Active> queryActiveByUser(long uid);
}
