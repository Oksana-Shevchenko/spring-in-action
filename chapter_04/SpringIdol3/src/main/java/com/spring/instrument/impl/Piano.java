package com.spring.instrument.impl;

import com.spring.instrument.IInstrument;
import com.spring.qualifiers.StringedInstrument;

@StringedInstrument
public class Piano implements IInstrument{
	public Piano() {}
	
	public void play() {
		System.out.println("PLINK PLINK PLINK");
	}
}
