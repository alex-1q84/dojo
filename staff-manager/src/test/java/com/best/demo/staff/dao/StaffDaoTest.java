package com.best.demo.staff.dao;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StaffDaoTest {

	@Resource
	private StaffDao staffDao;
	
	@Test
	public void test_save() {
		Staff staff = new Staff();
		staffDao.save(staff);
		assertTrue(staff.getId() > 0);
	}

}
