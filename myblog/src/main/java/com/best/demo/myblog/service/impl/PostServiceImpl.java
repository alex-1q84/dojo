package com.best.demo.myblog.service.impl;

import java.util.List;

import com.best.demo.myblog.dao.Article;
import com.best.demo.myblog.dao.ArticleDao;
import com.best.demo.myblog.service.PostService;

public class PostServiceImpl implements PostService {

	private ArticleDao articleDao;
	
	public Article addArticle(Article article) {
		this.articleDao.save(article);
		return article;
	}

	public List<Article> queryArticleByUser(long uid) {
		return this.articleDao.getArticleByUser(uid);
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
