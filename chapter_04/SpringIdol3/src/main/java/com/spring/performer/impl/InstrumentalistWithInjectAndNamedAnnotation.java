package com.spring.performer.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;

public class InstrumentalistWithInjectAndNamedAnnotation implements IPerformer {

	private String song;
	
	@Inject
	@Named("guitar")
	private IInstrument instrument;
	
	public InstrumentalistWithInjectAndNamedAnnotation() {}
	
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
