package com.best.demo.myblog.dao;

import java.util.List;

public interface ArticleDao {

	public Article getArticle(long id);
	public List<Article> getArticleByUser(long uid);
	public void save(Article article);
	public void deleteAll();
}
