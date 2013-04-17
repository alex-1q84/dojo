package com.best.demo.staff.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.best.demo.staff.dao.Staff;
import com.best.demo.staff.dao.StaffDao;
import com.best.demo.staff.dao.StaffStatistic;
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
		return staffDao.getStaff(id);
	}

	public List<Staff> query(Staff staff) {
		return staffDao.query(staff);
	}

	public void update(Staff staff) {
		staffDao.update(staff);
	}

	public List<Staff> getStaffByName(String name) {
		return staffDao.getStaffByName(name);
	}

	@Override
	public List<StaffStatistic> statistic() {
		return staffDao.statistic();
	}

	@Override
	public List<Staff> queryByRange(Staff staff, int begin, int end) {
		return staffDao.queryByRange(staff, begin, end);
	}

}
