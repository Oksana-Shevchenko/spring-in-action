package com.spring.performer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;
import com.spring.qualifiers.StringedInstrument;

public class InstrumentalistWithAutowiredAndCustQualifierAnnotation implements IPerformer {
	@Value("Eruption")
	private String song;
	@Autowired
	@StringedInstrument
	private IInstrument instrument;
	
	public InstrumentalistWithAutowiredAndCustQualifierAnnotation(){}
	
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
