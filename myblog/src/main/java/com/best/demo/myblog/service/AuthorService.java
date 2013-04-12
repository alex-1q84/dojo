package com.best.demo.myblog.service;

import com.best.demo.myblog.dao.User;

public interface AuthorService {

	public User addUser(User user);

	public User getUser(long id);
}
