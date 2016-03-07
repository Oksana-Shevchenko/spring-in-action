package com.spring.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ISpitterDAO;
import com.spring.dao.model.Spitter;

@Repository("dao")
@Transactional
public class JpaSpitterDao implements ISpitterDAO{
	
	private EntityManager em;
	
	private static final String SPITTER_FOR_USERNAME = "SELECT s FROM Spitter s WHERE s.username = :username";
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public void addSpitter(Spitter spitter) {
		em.persist(spitter);
	}

	public void saveSpitter(Spitter spitter) {
		em.merge(spitter);
	}

	public Spitter getSpitterById(long id) {
		return em.find(Spitter.class, id);
	}
	
	public Spitter getSpitterByUsername(String username) {
		return (Spitter) em.createQuery(SPITTER_FOR_USERNAME).setParameter("username", username).getSingleResult();
	}
}
