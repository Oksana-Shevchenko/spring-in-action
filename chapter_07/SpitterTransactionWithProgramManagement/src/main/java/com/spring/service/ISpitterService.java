package com.spring.service;

import java.util.List;

import com.spring.model.Spitter;

public interface ISpitterService {
	public void saveSpitter(Spitter spitter);
	public Spitter getSpitter(long id);
	public Spitter getSpitter(String username);
	public List<Spitter> getAllSpitters();
}
