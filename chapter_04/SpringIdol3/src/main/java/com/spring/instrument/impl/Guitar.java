package com.spring.instrument.impl;

import com.spring.instrument.IInstrument;

public class Guitar implements IInstrument {
	public Guitar() {}
	public void play() {
		System.out.println("Guitar Guitar Guitar");
	}
}
