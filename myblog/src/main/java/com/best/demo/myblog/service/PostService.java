package com.best.demo.myblog.service;

import java.util.List;

import com.best.demo.myblog.dao.Article;

public interface PostService {

	public Article addArticle(Article article);
	
	public List<Article> queryArticleByUser(long uid);
}
