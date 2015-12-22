package com.spring.componentScan;

import org.springframework.stereotype.Component;

import com.spring.instrument.IInstrument;
@Component("guitarComponentScan")
public class Guitar implements IInstrument {
	public Guitar() {}
	public void play() {
		System.out.println("Guitar Guitar Guitar");
	}
}
