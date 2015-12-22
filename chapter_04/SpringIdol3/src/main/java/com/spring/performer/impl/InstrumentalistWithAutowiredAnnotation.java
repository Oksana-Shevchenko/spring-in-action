package com.spring.performer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;

public class InstrumentalistWithAutowiredAnnotation implements IPerformer {
	private String song;
	@Autowired
	@Qualifier("stringed")
	private IInstrument instrument;
	
	public InstrumentalistWithAutowiredAnnotation() {}
	public void perform() throws PerformerException {
		System.out.println("Playing: "+song+ " : ");
		instrument.play();
	}
	public String screamSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public String getSong() {
		return song;
	}

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	public IInstrument getInstrument() {
		return instrument;
	}
}
