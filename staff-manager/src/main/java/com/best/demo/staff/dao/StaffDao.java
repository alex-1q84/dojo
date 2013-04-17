package com.best.demo.staff.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StaffDao {

	@Transactional
	public void save(Staff staff);
	
	public Staff getStaff(long id);
	
	public List<Staff> query(Staff staff);
	
	public List<Staff> queryByRange(@Param("staff")Staff staff, @Param("begin")int begin, @Param("end")int end);
	
	@Transactional
	public void update(Staff staff);
	
	@Transactional
	public void delete(long id);
	
	@Transactional
	public void deleteAll();

	public List<Staff> getStaffByName(String name);
	
	public List<StaffStatistic> statistic();
}
