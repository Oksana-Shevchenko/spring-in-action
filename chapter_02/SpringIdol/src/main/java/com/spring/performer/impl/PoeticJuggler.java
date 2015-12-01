package com.spring.performer.impl;

import com.spring.poem.IPoem;

public class PoeticJuggler extends Juggler {
	private IPoem poem;
	
	public PoeticJuggler(IPoem poem) {
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler(int beanBags, IPoem poem) {
		super(beanBags);
		this.poem = poem;
	}
	
	public void perform() throws PerformerException {
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}
}
