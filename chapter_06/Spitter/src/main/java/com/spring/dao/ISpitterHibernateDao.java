package com.spring.dao;

import com.spring.model.Spitter;

public interface ISpitterHibernateDao {
	public void addSpitter(Spitter spitter);
	public void saveSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
}
