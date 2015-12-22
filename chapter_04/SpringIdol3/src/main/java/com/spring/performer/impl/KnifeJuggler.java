package com.spring.performer.impl;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;

import com.spring.knife.Knife;

public class KnifeJuggler extends Juggler {
	private Set<Knife> knives;
	
	@Inject
	public KnifeJuggler(Provider<Knife> knifeProvider) {
		super();
		knives = new HashSet<Knife>();
		for (int i = 0; i < 5; i++) {
			knives.add(knifeProvider.get());
		}
	}
	
	public void perform() throws PerformerException {
		System.out.println("Knife Juggler perform..."+knives.size());
	}
}
