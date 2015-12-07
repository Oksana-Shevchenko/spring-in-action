package com.spring.performer.impl;

import java.util.Collection;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;

public class OneManBand implements IPerformer {
	private Collection<IInstrument> instruments;
	
	public OneManBand(){}
	
	public void perform() throws PerformerException {
		for(IInstrument instrument: instruments){
			instrument.play();
		}
	}
	
	public void setInstruments(Collection<IInstrument> instruments) {
		this.instruments = instruments;
	}
}
