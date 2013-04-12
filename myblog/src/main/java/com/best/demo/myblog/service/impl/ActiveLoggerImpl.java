package com.best.demo.myblog.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.best.demo.myblog.dao.Active;
import com.best.demo.myblog.dao.Article;
import com.best.demo.myblog.dao.User;
import com.best.demo.myblog.service.ActiveLogger;
import com.best.demo.myblog.service.ActiveService;
import com.best.demo.myblog.service.AuthorService;

public class ActiveLoggerImpl implements ActiveLogger {

	private static final Log log = LogFactory.getLog(ActiveLoggerImpl.class);
	
	private AuthorService authorService;
	private ActiveService activeService;
	
	public void logAddArticle(Article article) {
		log.info(buildDesc(article));
		Active active = new Active(article.getUid(), buildDesc(article), new Date());
		activeService.addActive(active);
	}

	private String buildDesc(Article article) {
		User user = this.authorService.getUser(article.getUid());
		return String.format("用户 %s 在 %s 发表了新文章 %s",
				user.getName(), article.getCreateDate(), article.getTitle());
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	public void setActiveService(ActiveService activeService) {
		this.activeService = activeService;
	}

	public void logAddUser(User user) {
		log.info(String.format("新用户 %s 注册", user.getName()));
	}

}
