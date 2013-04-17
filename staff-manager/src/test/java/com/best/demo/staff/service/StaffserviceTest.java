package com.best.demo.staff.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.best.demo.staff.dao.Department;
import com.best.demo.staff.dao.DepartmentDao;
import com.best.demo.staff.dao.Staff;
import com.best.demo.staff.dao.StaffDao;
import com.best.demo.staff.dao.StaffStatistic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StaffserviceTest {

	@Resource
	private StaffService staffService;
	
	@Resource
	private StaffDao staffDao;
	
	@Resource
	private DepartmentDao deptDao;
	
	@Resource
	private DepartmentService deptService;
	
	@After
	public void teardown(){
		staffDao.deleteAll();
		deptDao.deleteAll();
	}
	
	@Test
	public void test_addStaff() {
		Staff staff = new Staff(1, 1, "001", "hai", "13412341234", "#!12341", "地址地址地址地址", 1, true);
		staff = staffService.addStaff(staff);
		assertTrue(staff.getId() > 0);
	}

	@Test
	public void test_getStaffByName(){
		addStaffs();
		
		String prefix = "ha";
		List<Staff> staffs = staffService.getStaffByName(prefix);
		assertEquals(3, staffs.size());
		
		for (Staff staff : staffs) {
			assertTrue(staff.getName().startsWith(prefix));
		}
	}
	
	@Test
	public void test_query_with_name(){
		addStaffs();
		Staff staff = new Staff();
		staff.setName("ha");
		List<Staff> staffs = staffService.query(staff);
		assertEquals(3, staffs.size());
		
		for (Staff item : staffs) {
			assertTrue(item.getName().startsWith(staff.getName()));
		}
	}

	@Test
	public void test_query_with_name_and_department(){
		addStaffs();
		Staff staff = new Staff();
		staff.setName("ha");
		staff.setDeptId(1);
		List<Staff> staffs = staffService.query(staff);
		assertEquals(2, staffs.size());
		
		for (Staff item : staffs) {
			assertTrue(item.getName().startsWith(staff.getName()));
		}
	}
	
	@Test
	public void test_queryByRange_with_station_and_department_at_record_amount_enough(){
		Department department = deptService.addDepartment(new Department("0001", "研发部"));
		addStaffs(2, department.getId(), 20);
		
		Staff staff = new Staff();
		staff.setStationId(2);
		staff.setDeptId(department.getId());
		List<Staff> staffs = staffService.queryByRange(staff, 1, 10);
		assertEquals(10, staffs.size());
	}
	
	@Test
	public void test_queryByRange_with_station_and_department_at_record_amount_not_enough(){
		Department department = deptService.addDepartment(new Department("0001", "研发部"));
		addStaffs(2, department.getId(), 8);
		
		Staff staff = new Staff();
		staff.setStationId(2);
		staff.setDeptId(department.getId());
		List<Staff> staffs = staffService.queryByRange(staff, 1, 10);
		assertEquals(7, staffs.size());
	}
	
//	@Test
//	public void test_queryByRange_with_name_and_department_at_record_amount_not_enough(){
//		Department department = deptService.addDepartment(new Department("0001", "研发部"));
//		addStaffs(2, department.getId(), 8);
//		
//		Staff staff = new Staff();
//		staff.setName("hai");
//		staff.setDeptId(department.getId());
//		List<Staff> staffs = staffService.queryByRange(staff, 1, 10);
//		assertEquals(7, staffs.size());
//	}
	
	//联合查询
	@Test
	public void test_getStaff(){
		Department department = deptService.addDepartment(new Department("0001", "研发部"));
		Staff staff = staffService.addStaff(new Staff(1, department.getId(), "001",
				"hai", "13412341234", "#!12341", "地址地址地址地址", 1, true));
		assertNull(staff.getDepartment());
		
		staff = staffService.getStaff(staff.getId());
		assertNotNull(staff.getDepartment());
		assertEquals("0001", staff.getDepartment().getCode());
	}
	
	@Test
	public void test_statistic(){
		initStaffAndDepartmentData();
		
		List<StaffStatistic> result = staffService.statistic();
		assertEquals(5, result.size());
		
		List<Integer> counts = new ArrayList<Integer>();
		for (StaffStatistic item : result) {
			counts.add(item.getCount());
		}
		
		Collections.sort(counts);
		
		List<Integer> expect = new ArrayList<Integer>(Arrays.asList(11,10,9,20,2));
		Collections.sort(expect);
		
		assertEquals(expect, counts);
	}
	
	@Test
	public void test_parse_json(){
		initStaffAndDepartmentData();
		List<StaffStatistic> report = staffService.statistic();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonGenerator generator = mapper.getJsonFactory().
					createJsonGenerator(System.out, JsonEncoding.UTF8);
			generator.writeObject(report);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	private void addStaffs() {
		staffService.addStaff(new Staff(1, 1, "001", "hai", "13412341234", "#!12341", "地址地址地址地址", 1, true));
		staffService.addStaff(new Staff(1, 2, "002", "haiha", "13412341234", "#!12341", "地址地址地址地址", 1, false));
		staffService.addStaff(new Staff(2, 1, "003", "hai123", "13412341234", "#!12341", "地址地址地址地址", 1, true));
		staffService.addStaff(new Staff(3, 2, "004", "changhai123", "13412341234", "#!12341", "地址地址地址地址", 1, true));
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
