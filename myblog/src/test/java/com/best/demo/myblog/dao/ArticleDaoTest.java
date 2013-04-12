package com.best.demo.myblog.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

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
public class ArticleDaoTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private ArticleDao articleDao;
	
	@Before
	public void setUp(){
		Article article = new Article(1, "标题一", "测试测试测试测试测试测试测试测试", new Date(), new Date());
		articleDao.save(article);
	}
	
	@After
	public void tearDown(){
		articleDao.deleteAll();
	}
	
	@Test
	public void testGetArticleByUser() {
		List<Article> articles = articleDao.getArticleByUser(1);
		System.out.println("articles size : " + articles.size());
		assertNotNull(articles);
		assertTrue(articles.size() > 0);
	}

	@Test
	public void testSave() {
		Article article = new Article(1, "标题二", "测试测试测试测试测试测试测试测试", new Date(), new Date());
		articleDao.save(article);
		assertTrue(article.getId() > 0);
	}

//	@Test
//	public void testUpdate() {
//		List<Article> articles = articleDao.getArticleByUser(1);
//		String content = "这是个修改";
//		articles.get(0).setContent(content);
//		articleDao.update(articles.get(0));
//		user = articleDao.getUser(user.getId());
//		assertEquals(email, user.getEmail());
//	}

//	@Test
//	public void testDelete() {
//		User user = articleDao.getUserByName("test1");
//		articleDao.delete(user.getId());
//		assertNull(articleDao.getUser(user.getId()));
//	}

}
