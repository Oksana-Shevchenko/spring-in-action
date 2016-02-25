package com.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.ISpitterHibernateDao;
import com.spring.model.Spitter;

@Repository
public class HibernateSpitterDao implements ISpitterHibernateDao {
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpitterDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}
	
	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}
	
	public void saveSpitter(Spitter spitter) {
		currentSession().update(spitter);
	}
}
