package com.best.demo.staff.service;

import java.util.List;

import com.best.demo.staff.dao.Staff;

public interface StaffService {

	public Staff addStaff(Staff staff);
	
	public Staff getStaff(long id);
	
	public List<Staff> query(Staff staff);
	
	public void update(Staff staff);
}
