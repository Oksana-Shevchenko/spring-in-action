package com.spring.hibernate.annotated.dao;

import com.spring.hibernate.annotated.model.Spitter;

public interface ISpitterDao {
	public void addSpitter(Spitter spitter);
	public void saveSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
}
