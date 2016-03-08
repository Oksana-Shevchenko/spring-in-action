package com.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

	@Autowired
    public void setTemplate(HibernateTemplate hibernateTemplate)
    {
		setHibernateTemplate(hibernateTemplate);
    }
}
