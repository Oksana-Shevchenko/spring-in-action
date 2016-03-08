package com.spring.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springmodules.cache.annotations.CacheFlush;
import org.springmodules.cache.annotations.Cacheable;

import com.spring.dao.RantDao;
import com.spring.dao.model.Rant;

public class HibernateRantDao extends CustomHibernateDaoSupport implements RantDao {
	private static final String RANT = Rant.class.getName();
	
	public HibernateRantDao() {}
	
	//@Cacheable(modelId="rantzCacheModel")
	public List<Rant> getRantsForDay(Date day) {
		return getHibernateTemplate().find("from " + RANT +	" where postedDate = ?", day);
	}
	
	//@CacheFlush(modelId="rantzFlushModel")
	public void saveRant(Rant rant) {
		getHibernateTemplate().saveOrUpdate(rant);
	}

	public List<Rant> getAllRants() {
		 return getHibernateTemplate().find("from " + RANT);
	}
}
