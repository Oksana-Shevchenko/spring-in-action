package com.spring.performer.impl;

import java.util.Iterator;
import java.util.Properties;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;

public class OneManBandProperties implements IPerformer {
	private Properties instruments;
	
	public OneManBandProperties(){}
	public void perform() throws PerformerException {
		Iterator it = instruments.keySet().iterator();
		 while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void setInstruments(Properties instruments) {
		this.instruments = instruments;
	}
}
