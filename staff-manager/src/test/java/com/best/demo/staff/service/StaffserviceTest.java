package com.best.demo.staff.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.best.demo.staff.dao.Staff;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StaffserviceTest {

	@Resource
	private StaffService staffService;
	
	@Test
	public void test_addStaff() {
		Staff staff = new Staff();
		staffService.addStaff(staff);
		assertTrue(staff.getId() > 0);
	}

}
