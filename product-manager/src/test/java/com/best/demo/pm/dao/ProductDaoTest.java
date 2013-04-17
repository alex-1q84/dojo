package com.best.demo.pm.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.best.demo.pm.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProductDaoTest {

	@Autowired
	private ProductDao productDao;
	
	@After
	public void tearDown(){
		productDao.deleteAll();
		System.out.println("delete all -----------------");
	}
	
	@Test
	public void testSave() {
		Product prod = new Product("0001", "测试");
		productDao.save(prod);
	}

	@Test
	public void testUpdate() {
		String prodCode = "0001";
		Product prod = new Product(prodCode, "测试");
		productDao.save(prod);
		
		prod.setProdName("测试改");
		productDao.update(prod);
	}
	
	@Test
	public void test_saveOrUpdate() {
		String prodCode = "0001";
		Product prod = new Product(prodCode, "测试");
		productDao.saveOrUpdate(prod);
		
		prod.setProdName("测试改");
		productDao.saveOrUpdate(prod);
	}

	@Test
	public void testDelete() {
		String prodCode = "0001";
		Product prod = new Product(prodCode, "测试");
		productDao.save(prod);
		
		//持久化的实体才可以删除
		//prod = new Product(prodCode, "测试");
		productDao.delete(prod);
		
		Product product = this.productDao.findByProdCode(prodCode);
		assertNull(product);
	}

	@Test
	public void testFindByProdCode() {
		String prodCode = "0001";
		Product prod = new Product(prodCode, "测试");
		productDao.save(prod);
		Product product = this.productDao.findByProdCode(prodCode);
		assertEquals(prodCode, product.getProdCode());
	}

}
