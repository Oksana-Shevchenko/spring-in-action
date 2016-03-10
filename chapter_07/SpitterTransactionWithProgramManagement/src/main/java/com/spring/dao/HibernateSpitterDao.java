package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.model.Spitter;
@Repository
public class HibernateSpitterDao implements ISpitterDao {
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	
	private static final String SPITTER = Spitter.class.getName();
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveSpitter(Spitter spitter) {
		currentSession().update(spitter);
	}
	
	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}
	
	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	public Spitter getSpitterByUsername(String username) {
		return (Spitter) currentSession().get(Spitter.class, username);
	}

	public List<Spitter> findAllSpitters() {
		return hibernateTemplate.find("from " + SPITTER);
	}
}
