package com.spring.instrument.impl;

import com.spring.instrument.IInstrument;

public class Saxophone implements IInstrument {
	public Saxophone() {}

	public void play() {
		System.out.println("TOOT TOOT TOOT");
	}
}
