package com.spring.performer.impl;

import com.spring.performer.IPerformer;

public class Juggler implements IPerformer {
	private int beanBags =3;
	
	public Juggler() { }
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	public void perform() throws PerformerException {
		System.out.println("JUGGLING "+beanBags+" BEANBAGS");
	}
}
