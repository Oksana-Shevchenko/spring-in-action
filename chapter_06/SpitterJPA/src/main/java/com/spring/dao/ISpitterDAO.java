package com.spring.dao;

import com.spring.dao.model.Spitter;

public interface ISpitterDAO {
	public void addSpitter(Spitter spitter);
	public void saveSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
	public Spitter getSpitterByUsername(String username);
}
