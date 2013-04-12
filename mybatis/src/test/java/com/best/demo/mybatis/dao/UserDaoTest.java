package com.best.demo.mybatis.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//这里需注意junit版本与spring版本一致
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private UserDao userDao;
	
	@Before
	public void setUp(){
		User user = new User("test1", "test1@gmail.com", "#@!qwerq134");
		userDao.save(user);
	}
	
	@After
	public void tearDown(){
		userDao.deleteAll();
	}
	
	@Test
	public void testGetUser() {
		User user = userDao.getUserByName("test1");
		assertNotNull(user);
		assertEquals("test1", user.getName());
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setEmail("hailxl@gmail.com");
		user.setName("wch");
		user.setPassword("#$#ASDF134");
		userDao.save(user);
		assertTrue(user.getId() > 0);
	}

	@Test
	public void testUpdate() {
		User user = userDao.getUserByName("test1");
		String email = "hai@best.com";
		user.setEmail(email);
		userDao.update(user);
		user = userDao.getUser(user.getId());
		assertEquals(email, user.getEmail());
	}

	@Test
	public void testDelete() {
		User user = userDao.getUserByName("test1");
		userDao.delete(user.getId());
		assertNull(userDao.getUser(user.getId()));
	}

}
