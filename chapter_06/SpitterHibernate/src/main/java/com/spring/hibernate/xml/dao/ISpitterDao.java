package com.spring.hibernate.xml.dao;

import com.spring.hibernate.xml.model.Spitter;

public interface ISpitterDao {
	public void addSpitter(Spitter spitter);
	public void saveSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
}
