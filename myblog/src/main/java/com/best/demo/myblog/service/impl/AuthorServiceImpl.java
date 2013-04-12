package com.best.demo.myblog.service.impl;

import com.best.demo.myblog.dao.User;
import com.best.demo.myblog.dao.UserDao;
import com.best.demo.myblog.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

	private UserDao userDao;
	
	public User addUser(User user) {
		this.userDao.save(user);
		return user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUser(long id) {
		return this.userDao.getUser(id);
	}
}
