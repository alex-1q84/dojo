package com.best.demo.staff.task;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.best.demo.staff.dao.Department;
import com.best.demo.staff.dao.Staff;
import com.best.demo.staff.service.DepartmentService;
import com.best.demo.staff.service.StaffService;

public class DemoRunner {

	private StaffService staffService;
	private DepartmentService deptService;
	private ApplicationContext context;
	
	public DemoRunner(ApplicationContext context) {
		this.context = context;
		this.staffService = this.context.getBean(StaffService.class);
		this.deptService = this.context.getBean(DepartmentService.class);
	}

	public static void main(String[] args) {
		DemoRunner runner = new DemoRunner(
				new FileSystemXmlApplicationContext("classpath:applicationContext.xml"));
		runner.initStaffAndDepartmentData();
	}
	
	private void initStaffAndDepartmentData() {
		Department department = deptService.addDepartment(new Department("0001", "研发部"));
		addStaffs(1, department.getId(), 11);
		
		department = deptService.addDepartment(new Department("0002", "研发部2"));
		addStaffs(2, department.getId(), 10);
		
		department = deptService.addDepartment(new Department("0003", "研发部3"));
		addStaffs(3, department.getId(), 9);
		
		department = deptService.addDepartment(new Department("0004", "研发部4"));
		addStaffs(3, department.getId(), 20);
		
		department = deptService.addDepartment(new Department("0004", "研发部"));
		addStaffs(4, department.getId(), 2);
	}
	
	private void addStaffs(long stationId, long deptId, int amount) {
		Random rand = new Random(System.currentTimeMillis());
		for(int i=0; i<amount; i++){
			staffService.addStaff(new Staff(stationId, deptId, RandomStringUtils.randomNumeric(4),
					"hai" + RandomStringUtils.randomAscii(5), "13412341234",
					"#!12341", "地址地址地址地址", 1, rand.nextBoolean()));
		}
	}
}
