package com.best.demo.staff.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StaffDao {

	@Transactional
	public void save(Staff staff);
	
	public Staff getStaff(long id);
	
	public List<Staff> query(Staff staff);
	
	@Transactional
	public void update(Staff staff);
	
	@Transactional
	public void delete(long id);
	
	@Transactional
	public void deleteAll();
}
