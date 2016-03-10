package com.spring.dao;

import java.util.List;

import com.spring.model.Spitter;

public interface ISpitterDao {
	public void saveSpitter(Spitter spitter);
	public void addSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
	public Spitter getSpitterByUsername(String username);
	public List<Spitter> findAllSpitters();
}
