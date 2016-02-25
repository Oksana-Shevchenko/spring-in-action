package com.spring.dao;

import com.spring.model.Spitter;

public interface ISpitterDAO {
	public void addSpitter(Spitter spitter);
	public Spitter getSpitterById(long id);
}
