package com.best.demo.myblog.service;

import com.best.demo.myblog.dao.Article;
import com.best.demo.myblog.dao.User;


public interface ActiveLogger {

	public void logAddArticle(Article article);
	public void logAddUser(User user);
}
