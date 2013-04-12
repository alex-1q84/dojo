package com.best.demo.myblog.dao;


public interface UserDao {

	public User getUser(long id);
	
	public User getUserByName(String name);
	
	public void save(User user);
	
	public void update(User user);
	
	public void delete(long id);
	
	public void deleteAll();
}
