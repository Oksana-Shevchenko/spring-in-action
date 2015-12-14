package com.spring.performer.impl;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;

public abstract class Instrumentalist_useLookupMethod implements IPerformer {
	private String song;
	
	public Instrumentalist_useLookupMethod() {}
	
	public void perform() throws PerformerException {
		System.out.print("Playing " + song + " : ");
		getInstrument().play();
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	public abstract IInstrument getInstrument();
}
