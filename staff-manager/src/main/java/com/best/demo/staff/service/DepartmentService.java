package com.best.demo.staff.service;

import com.best.demo.staff.dao.Department;

public interface DepartmentService {

	public Department addDepartment(Department dept);
	
	public Department getDepartment(long id);
}
