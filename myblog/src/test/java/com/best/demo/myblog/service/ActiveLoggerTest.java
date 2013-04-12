package com.best.demo.myblog.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.best.demo.myblog.dao.Active;
import com.best.demo.myblog.dao.ActiveDao;
import com.best.demo.myblog.dao.Article;
import com.best.demo.myblog.dao.ArticleDao;
import com.best.demo.myblog.dao.User;
import com.best.demo.myblog.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ActiveLoggerTest {

	@Resource
	private ActiveService activeService;
	@Resource
	private PostService postService;
	@Resource
	private AuthorService authorService;
	@Resource
	private UserDao userDao;
	@Resource
	private ArticleDao articleDao;
	@Resource
	private ActiveDao activeDao;
	
	@Before
	public void setUp(){
		articleDao.deleteAll();
		activeDao.deleteAll();
		userDao.deleteAll();
	}
	
	@Test
	public void test_log_active_after_add_article() {
		User user = new User("hai", "hai@best.com", "#!1234$");
		authorService.addUser(user);
		
		Article article = new Article(user.getId(), "aop是个好东西", "一师是个好部队", new Date(), new Date());
		postService.addArticle(article);
		
		List<Active> actives = activeService.queryActiveByUser(user.getId());
		assertNotNull(actives);
		assertTrue(actives.size() > 0);
		assertNotNull(actives.get(0));
	}

}
