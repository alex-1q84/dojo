package com.best.demo.staff.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.best.demo.staff.dao.Staff;
import com.best.demo.staff.dao.StaffDao;
import com.best.demo.staff.service.StaffService;

@Component
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	
	public Staff addStaff(Staff staff) {
		staffDao.save(staff);
		return staff;
	}

	public Staff getStaff(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Staff> query(Staff staff) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Staff staff) {
		// TODO Auto-generated method stub

	}

}
