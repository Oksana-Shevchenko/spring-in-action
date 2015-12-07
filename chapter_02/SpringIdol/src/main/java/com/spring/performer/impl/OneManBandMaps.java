package com.spring.performer.impl;

import java.util.Map;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;

public class OneManBandMaps implements IPerformer {
	private Map<String, IInstrument> instruments;
	
	public OneManBandMaps(){}
	
	public void perform() throws PerformerException {
		for(String key: instruments.keySet()){
			IInstrument instrument = instruments.get(key);
			instrument.play();
		}
	}
	
	public void setInstruments(Map<String, IInstrument> instruments) {
		this.instruments = instruments;
	}
}
