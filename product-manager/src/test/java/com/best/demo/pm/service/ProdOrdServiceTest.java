package com.best.demo.pm.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.best.demo.pm.dao.ProdOrdDao;
import com.best.demo.pm.dao.ProdOrdRelDao;
import com.best.demo.pm.dao.ProductDao;
import com.best.demo.pm.entity.ProdOrd;
import com.best.demo.pm.entity.ProdOrdRel;
import com.best.demo.pm.entity.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProdOrdServiceTest {

	@Autowired
	private ProdOrdService prodOrdService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProdOrdDao prodOrdDao;
	
	@Autowired
	private ProdOrdRelDao prodOrdRelDao;
	
	@After
	public void tearDown(){
		this.prodOrdDao.deleteAll();
		this.prodOrdRelDao.deleteAll();
		this.productDao.deleteAll();
	}
	
	@Test
	public void testRequireProds() {
		List<Product> prods = new ArrayList<Product>();
		for(int i=0; i<10; i++){
			Product prod = new Product("0000" + i, RandomStringUtils.randomAscii(10));
			productDao.save(prod);
			prods.add(prod);
		}
		
		ProdOrd ord = new ProdOrd();
		ord.setSheetCode("00123400056");
		List<ProdOrdRel> rels = new ArrayList<ProdOrdRel>();
		
		for (Product product : prods) {
			ProdOrdRel rel = new ProdOrdRel();
			rel.setMinimumAmount(5);
			rel.setAmount(10);
			rel.setMoney(1000);
			rel.setProduct(product);
			rels.add(rel);
		}
		
		ProdOrd savedOrd = this.prodOrdService.requireProds(ord, rels);
		assertTrue(savedOrd.getOrdId() > 0);
		for (ProdOrdRel rel : rels) {
			assertEquals(savedOrd.getOrdId(), rel.getProdOrd().getOrdId());
		}
	}

	@Test
	public void testRequireProds_with_unexists_product() {
		ProdOrd ord = new ProdOrd();
		ord.setSheetCode("00123400056");
		List<ProdOrdRel> rels = new ArrayList<ProdOrdRel>();
		
		for (int i=1; i<6; i++) {
			ProdOrdRel rel = new ProdOrdRel();
			rel.setMinimumAmount(5);
			rel.setAmount(10);
			rel.setMoney(1000);
			rel.setProduct(new Product(i));
			rels.add(rel);
		}
		
		ProdOrd savedOrd = this.prodOrdService.requireProds(ord, rels);
		assertTrue(savedOrd.getOrdId() > 0);
		for (ProdOrdRel rel : rels) {
			assertEquals(savedOrd.getOrdId(), rel.getProdOrd().getOrdId());
		}
	}
}
