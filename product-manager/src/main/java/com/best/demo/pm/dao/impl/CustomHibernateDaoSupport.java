package com.best.demo.pm.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * HibernateDaoSupport 辅助类
 * @author <a href="mailto:hailxl@gmail.com">wuch</a>
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

	//注入sessionFactory实例
    @Autowired
    public void anyMethodName(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }
}
