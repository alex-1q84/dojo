package com.best.demo.staff.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.best.demo.staff.dao.Staff;
import com.best.demo.staff.dao.StaffStatistic;

public interface StaffService {

	@Transactional
	public Staff addStaff(Staff staff);
	
	public Staff getStaff(long id);
	
	/**
	 * 按名称模糊查询
	 * @param name
	 * @return
	 */
	public List<Staff> getStaffByName(String name);
	
	public List<Staff> query(Staff staff);
	
	public List<Staff> queryByRange(Staff staff, int begin, int end);
	
	@Transactional
	public void update(Staff staff);
	
	public List<StaffStatistic> statistic();
}
