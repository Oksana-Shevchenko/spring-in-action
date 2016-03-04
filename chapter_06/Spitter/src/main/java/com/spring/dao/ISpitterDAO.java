package com.spring.dao;

import com.spring.model.Spitter;

public interface ISpitterDAO {
	public void addSpitter(Spitter spitter);
	public void addSpitterWithNamedParameters(Spitter spitter);
	public Spitter getSpitterByUsername(String username);
}
