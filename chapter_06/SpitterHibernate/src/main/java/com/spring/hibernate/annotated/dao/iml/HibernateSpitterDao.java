package com.spring.hibernate.annotated.dao.iml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.annotated.dao.ISpitterDao;
import com.spring.hibernate.annotated.model.Spitter;

@Repository
public class HibernateSpitterDao implements ISpitterDao {
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
