package com.best.demo.staff.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DepartmentDao {

	public void save(Department department);
	
	public void deleteAll();
	
	public Department getDepartmet(long id);
}
