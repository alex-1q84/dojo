package com.best.demo.staff.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.best.demo.staff.dao.Department;
import com.best.demo.staff.dao.DepartmentDao;
import com.best.demo.staff.service.DepartmentService;

@Component
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao deptDao;
	
	public Department addDepartment(Department dept) {
		deptDao.save(dept);
		return dept;
	}

	public Department getDepartment(long id) {
		return deptDao.getDepartmet(id);
	}

}
